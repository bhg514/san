package com.sist.mapredWeekday;

import javax.annotation.Resource;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;

@Component
public class WeekdayDriver {

	@Autowired
	   private Configuration conf;
		
		@Resource(name="weekdayj")
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
			    if(fs.exists(new Path("/input/weekday")))
			    	fs.delete(new Path("/input/weekday"),true);
			    
			    if(fs.exists(new Path("/output/weekday")))
			    	fs.delete(new Path("/output/weekday"),true);
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
					   new Path("/home/bhg/git/san/San/src/main/webapp/data/naver/san.txt"), 
					   new Path("/input/weekday/san.txt"));	
			   fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }

	   public void copyToLocal(){
		   try{
			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/weekday/part-r-00000"),
					   new Path("/home/bhg/git/san/San/src/main/webapp/data/naver/output/weekday/part-r-00000"));
			   fs.close();
			 					
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }
	
}
