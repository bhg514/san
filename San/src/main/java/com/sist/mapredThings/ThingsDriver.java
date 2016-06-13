package com.sist.mapredThings;

import javax.annotation.Resource;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;

@Component
public class ThingsDriver {
	@Autowired
	   private Configuration conf;
		
		@Resource(name="thingsj")
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
			    if(fs.exists(new Path("/input/things")))
			    	fs.delete(new Path("/input/things"),true);
			    
			    if(fs.exists(new Path("/output/things")))
			    	fs.delete(new Path("/output/things"),true);
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
					   new Path("/home/bhg/git/san/San/src/main/webapp/data/naver/things.txt"), 
					   new Path("/input/things/things.txt"));	
			   fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }

	   public void copyToLocal(){
		   try{
			
			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/things/part-r-00000"),
					   new Path("/home/bhg/git/san/San/src/main/webapp/data/naver/output/things/part-r-00000"));
			   fs.close();
			 					
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }

}
