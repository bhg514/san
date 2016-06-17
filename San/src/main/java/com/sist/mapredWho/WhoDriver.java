package com.sist.mapredWho;

import javax.annotation.Resource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;


@Component
public class WhoDriver {

	
	@Autowired
	   private Configuration conf;
		
		@Resource(name="whoj")
	   private JobRunner jobRunner;		
		
		public void jobCall(){
		   try{

			   jobRunner.call();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }
		
		
	   public void fileDelete(){
		   try{

			    FileSystem fs=FileSystem.get(conf);
			    if(fs.exists(new Path("/input/Recommand/who")))
			    	fs.delete(new Path("/input/Recommand/who"),true);
			    
			    if(fs.exists(new Path("/output/Recommand/who")))
			    	fs.delete(new Path("/output/Recommand/who"),true);
			    fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   } 
	   
	   public void copyFromLocal(){
		   try{

			   FileSystem fs1=FileSystem.get(conf);
			   // hadoop fs -cat /
			   fs1.copyFromLocalFile(
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/recommand_san.txt"), 
					   new Path("/input/Recommand/who/who.txt"));	
			   fs1.close();
			   
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }
	   

	   public void copyToLocal(){
		   try{

			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/Recommand/who/part-r-00000"),
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/output/recommand/who/part-r-00000")); //영화감정분석
			   fs.close();			   
				
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }
	   
}
