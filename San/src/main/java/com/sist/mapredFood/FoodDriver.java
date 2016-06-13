package com.sist.mapredFood;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;

import java.io.*;

import javax.annotation.Resource;

@Component
public class FoodDriver {

	
		@Autowired
	   private Configuration conf;
		
		@Resource(name="foodj")
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
			
			    if(fs.exists(new Path("/input/food")))
			    	fs.delete(new Path("/input/food"),true);

			    if(fs.exists(new Path("/output/food")))
			    	fs.delete(new Path("/output/food"),true);
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
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/san.txt"), 
					   new Path("/input/food/san.txt"));	
			   fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }

	   public void copyToLocal(){
		   try{
			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/food/part-r-00000"),
					   new Path("/home/sist/git/san/San/src/main/webapp/data/naver/output/food/part-r-00000"));
			   fs.close();
			 					
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }

}