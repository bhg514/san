package com.sist.mapred;

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
@Component
public class NaverDriver {
		@Autowired
	   private Configuration conf;
		@Autowired
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
			    if(fs.exists(new Path("/input")))
			    	fs.delete(new Path("/input"),true);
			    
			    if(fs.exists(new Path("/output")))
			    	fs.delete(new Path("/output"),true);
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
					   new Path("/home/sist/git/P3_FinalProject/Fit/src/main/webapp/data/naver/naver.txt"), 
					   new Path("/input/naver.txt"));
		      fs.close();
		   }catch(Exception ex){
			   System.out.println(ex.getMessage());
		   }
	   }

	   public void copyToLocal(){
		   try{
			   FileSystem fs=FileSystem.get(conf);
			   fs.copyToLocalFile(
					   new Path("/output/part-r-00000"),
					   new Path("/home/sist/git/P3_FinalProject/Fit/src/main/webapp/data/naver/output/part-r-00000"));
			   fs.close();
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }
	
	
	////////////////
	
/*	public void movieMapReduce(){
		try{
			Configuration conf=new Configuration();
			Job job=new Job(conf,"NaverCount");
			job.setJarByClass(NaverDriver.class);
			job.setMapperClass(NaverMapper.class);
			job.setReducerClass(NaverReducer.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			FileInputFormat.addInputPath(job, new Path("/home/sist/git/P3_FinalProject/Fit/src/main/webapp/data/naver/naver.txt"));
			File dir=new File("/home/sist/git/P3_FinalProject/Fit/src/main/webapp/data/naver/output");
			if(dir.exists()){
				File[] files=dir.listFiles();
				for(File f:files){
					f.delete();
				}
				dir.delete();
			}				
			FileOutputFormat.setOutputPath(job, new Path("/home/sist/git/P3_FinalProject/Fit/src/main/webapp/data/naver/output"));
			job.waitForCompletion(true);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}*/
}
