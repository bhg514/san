package com.sist.mapredRec;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;

@Component
public class RecommandDriver {
	
		@Autowired
	   private Configuration conf;
		
		@Resource(name="busanj")
		private JobRunner jobRunnerB;
		
		@Resource(name="chungbukj")
		private JobRunner jobRunnerC;
	   
		public void jobCallB(){
			   try{
					  jobRunnerB.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallC(){
			   try{
					  jobRunnerC.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		
	   public void fileDelete(){
		   try{
			    FileSystem fs=FileSystem.get(conf);
			    if(fs.exists(new Path("/input/recommand")))
			    	fs.delete(new Path("/input/recommand"),true);
			    
			    if(fs.exists(new Path("/output/recommand")))
			    	fs.delete(new Path("/output/recommand"),true);
			    fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }  
	   
	   public void copyFromLocal(){
		   try{
			   FileSystem fs=FileSystem.get(conf);
			   // hadoop fs -cat /
			   fs.copyFromLocalFile(
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/localsan.txt"), 
					   new Path("/input/recommand/localsan.txt"));	
			   fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }

	   public void copyToLocal(){
		   try{
			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/recommand/part-r-00000"),
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/output/recommand/part-r-00000"));
			   fs.close();
			 					
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }

}
