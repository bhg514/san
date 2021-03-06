package com.sist.mongo;

import org.springframework.stereotype.Repository;

import com.mongodb.*;

@Repository
public class SanDAO {
	
	private MongoClient mc;
	private DB db;
	private DBCollection dbc;
	private DBCollection dbc_things;
	public SanDAO(){
		
		try{
			mc=new MongoClient(new ServerAddress("localhost",27017));	//보영ip

			db=mc.getDB("sandb");
			dbc=db.getCollection("recommand");	// 테이블
			dbc_things=db.getCollection("thingsCollection");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
				
	}
	
		public void localInsert(LocalVO vo) {		//서울 30, 부산 20
			try{
				//1.시퀀스 만들기
				int max=0;
				DBCursor cursor=dbc.find();		
				while(cursor.hasNext()){
					BasicDBObject obj=(BasicDBObject)cursor.next();
					int no=obj.getInt("no");
					if(max<no){
						max=no;
					}
				}
				cursor.close();
				
				cursor=dbc.find();				
				boolean bCheck=false;
				int i=0;
				while(cursor.hasNext()){
					BasicDBObject obj=(BasicDBObject)cursor.next();
					String local=obj.getString("local");		//서울	부산
					String count=obj.getString("count");		//17	10.....
					i=obj.getInt("no");
					if(local.equals(vo.getLocal())){			//같은게 있으면 업데이트
						bCheck=true;
						break;
					}
				}
				cursor.close();
				
				if(bCheck==true){			//update					
					BasicDBObject where=new BasicDBObject();
					where.put("no", i);
					BasicDBObject obj=(BasicDBObject)dbc.findOne(where);		//해당 번호의 오브젝트만 가져옴
					BasicDBObject up=new BasicDBObject();
					up.put("no",obj.getInt("no"));			
					up.put("local", obj.getString("local"));	
					up.put("count", vo.getCount());			//count업데이트
					dbc.update(where, new BasicDBObject("$set",up));			
				}else{				//insert
					BasicDBObject in=new BasicDBObject();
					in.put("no", max+1);
					in.put("local",vo.getLocal());
					in.put("count", vo.getCount());
					dbc.insert(in);		//몽고디비의 recommand테이블에 추가 
				}
		
			}catch(Exception e){
				System.out.println("mongodb : "+e.getMessage());
			}
		}
		
		public void thingsInsert(ThingsVO vo) {		// 준비물
			try{
				//1.시퀀스 만들기
				int max=0;
				DBCursor cursor=dbc_things.find();		
				while(cursor.hasNext()){
					BasicDBObject obj=(BasicDBObject)cursor.next();
					int no=obj.getInt("no");
					if(max<no){
						max=no;
					}
				}
				cursor.close();
				
				cursor=dbc_things.find();				
				boolean bCheck=false;
				int i=0;
				while(cursor.hasNext()){
					BasicDBObject obj=(BasicDBObject)cursor.next();
					String things=obj.getString("things");	
					String count=obj.getString("count");	
					i=obj.getInt("no");
					if(things.equals(vo.getThings())){			//같은게 있으면 업데이트
						bCheck=true;
						break;
					}
				}
				cursor.close();
				
				if(bCheck==true){			//update					
					BasicDBObject where=new BasicDBObject();
					where.put("no", i);
					BasicDBObject obj=(BasicDBObject)dbc_things.findOne(where);		//해당 번호의 오브젝트만 가져옴
					BasicDBObject up=new BasicDBObject();
					up.put("no",obj.getInt("no"));			
					up.put("things", obj.getString("things"));	
					up.put("count", vo.getCount());			//count업데이트
					dbc_things.update(where, new BasicDBObject("$set",up));			
				}else{				//insert
					BasicDBObject in=new BasicDBObject();
					in.put("no", max+1);
					in.put("things",vo.getThings());
					in.put("count", vo.getCount());
					dbc_things.insert(in);					//몽고디비의 dbc_things테이블에 추가 
				}
		
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
}
