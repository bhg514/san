package com.sist.r;
import java.util.*;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

import com.sist.mongo.FeelVO;
import com.sist.mongo.LocalVO;
import com.sist.mongo.WeekdayVO;
@Component
public class NaverRManager {
	
	public void rGraph(){
		try{
			RConnection rc=new RConnection();			
			rc.voidEval("naver<-read.table(\"/home/sist/git/san/San/src/main/webapp/data/naver/output/part-r-00000\")");			
			rc.voidEval("png(\"/home/sist/git/san/San/src/main/webapp/R/naver.png\",width=900,height=500)");			
			rc.voidEval("par(mfrow=c(1,2))");//그림그리기			
			rc.voidEval("pie(naver$V2,labels=naver$V1,col=rainbow(10))");			
			rc.voidEval("barplot(naver$V2,names.arg=naver$V1d,col=rainbow(10))");			
			rc.voidEval("dev.off()");
			rc.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
		
		public List<LocalVO> rLocalData(){
			
			List<LocalVO> list=new ArrayList<LocalVO>();
			try{
				RConnection rc=new RConnection();
				rc.voidEval("data<-read.table(\"/home/sist/git/san/San/src/main/webapp/data/naver/output/local/part-r-00000\")");
				REXP p=rc.eval("data$V1");	//1.지역
				String[] local=p.asStrings();	
				p=rc.eval("data$V2");			//2.카운트
				int[] count=p.asIntegers();
				rc.close();
				
				for(int i=0; i<count.length; i++){
					if(count[i]>=7){				
						LocalVO vo=new LocalVO();
						vo.setLocal(local[i]);
						vo.setCount(count[i]);
						list.add(vo);
					}
				}
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			return list;
		}
		
		public List<SeasonVO> rSeasonData(){
			
			List<SeasonVO> list=new ArrayList<SeasonVO>();
			
			try{
				RConnection rc=new RConnection();
				rc.voidEval("data<-read.table(\"/home/sist/git/san/San/src/main/webapp/data/naver/output/season/part-r-00000\")");
				REXP p=rc.eval("data$V1");	//1.계절
				String[] season=p.asStrings();	
				p=rc.eval("data$V2");			//2.카운트
				int[] count=p.asIntegers();
				rc.close();
				
				for(int i=0; i<count.length; i++){			
						SeasonVO vo=new SeasonVO();
						vo.setSeason(season[i]);
						vo.setCount(count[i]);
						list.add(vo);
				}
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			return list;
		}
		
		public List<WeekdayVO> rWeekData(){
			
			List<WeekdayVO> list = new ArrayList<WeekdayVO>();
			
			try{
				RConnection rc = new RConnection();
				rc.voidEval("week<-read.table(\"/home/sist/git/san/San/src/main/webapp/data/naver/output/weekday/part-r-00000\")");
				REXP p = rc.eval("week$V1");
				String[] days = p.asStrings();
				p = rc.eval("week$V2");
				int[] count = p.asIntegers();
				rc.close();
				
				for(int i=0; i<days.length; i++){
					WeekdayVO vo = new WeekdayVO();
					vo.setDay(days[i]);
					vo.setCount(count[i]);
					list.add(vo);
				}
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
			return list;
		}
		
		public List<FeelVO> rFeelData(){
			
			List<FeelVO> list = new ArrayList<FeelVO>();
			
			try{
				
				RConnection rc = new RConnection();		
				rc.voidEval("feel<-read.table(\"/home/sist/git/san/San/src/main/webapp/data/naver/output/feel/part-r-00000\")");
				//rc.voidEval("feel<-read.table(\"/home/sist/data\")");
				
				REXP p = rc.eval("feel$V1");
				String[] feels = p.asStrings();
				p = rc.eval("feel$V2");
				int[] count = p.asIntegers();
				rc.close();

				for(int i=0; i<feels.length; i++){
					FeelVO vo = new FeelVO();
					vo.setFeel(feels[i]);
					vo.setCount(count[i]);
					list.add(vo);
				}
				
				
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
			
			return list;
		}
		
		
}
