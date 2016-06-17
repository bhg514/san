package com.sist.mapredFeel;

import javax.annotation.Resource;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;

@Component
public class FeelDriver {

	@Autowired
	   private Configuration conf;
		
		@Resource(name="feelj")
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
			    if(fs.exists(new Path("/input/feel")))
			    	fs.delete(new Path("/input/feel"),true);
			    
			    if(fs.exists(new Path("/output/feel")))
			    	fs.delete(new Path("/output/feel"),true);
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
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/san.txt"), 
					   new Path("/input/feel/san.txt"));	
			   fs1.close();
			   
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }
	   

	   public void copyToLocal(){
		   try{
			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/feel/part-r-00000"),
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/output/feel/part-r-00000"));
			   fs.close();			   
				
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }

}
