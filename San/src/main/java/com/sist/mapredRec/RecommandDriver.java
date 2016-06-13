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
	   
		@Resource(name="chungnamj")
		private JobRunner jobRunnerCN;
		
		@Resource(name="daejeonj")
		private JobRunner jobRunnerDJ;
		
		@Resource(name="daeguj")
		private JobRunner jobRunnerDG;
		
		@Resource(name="gangwonj")
		private JobRunner jobRunnerGW;
		
		@Resource(name="gyeongbukj")
		private JobRunner jobRunnerGB;
		
		@Resource(name="gyeongnamj")
		private JobRunner jobRunnerGN;
		
		@Resource(name="gyeonggij")
		private JobRunner jobRunnerGG;
		
		@Resource(name="incheonj")
		private JobRunner jobRunnerIC;
		
		@Resource(name="jejuj")
		private JobRunner jobRunnerJJ;
		
		@Resource(name="jeonbukj")
		private JobRunner jobRunnerJB;
		
		@Resource(name="jeonnamj")
		private JobRunner jobRunnerJN;
		
		@Resource(name="ulsanj")
		private JobRunner jobRunnerUS;
		
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
		public void jobCallCN(){
			   try{
					  jobRunnerCN.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallDJ(){
			   try{
					  jobRunnerDJ.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallDG(){
			   try{
					  jobRunnerDG.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallGW(){
			   try{
					  jobRunnerGW.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallGB(){
			   try{
					  jobRunnerGB.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallGN(){
			   try{
					  jobRunnerGN.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallGG(){
			   try{
					  jobRunnerGG.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallIC(){
			   try{
					  jobRunnerIC.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallJJ(){
			   try{
					  jobRunnerJJ.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallJB(){
			   try{
					  jobRunnerJB.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallJN(){
			   try{
					  jobRunnerJN.call();
			   }catch(Exception ex){
				   System.out.println(ex.getMessage());
			   }
		 }
		public void jobCallUS(){
			   try{
					  jobRunnerUS.call();
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
					   new Path("/home/bhg/git/san/San/src/main/webapp/data/naver/localsan.txt"), 
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
					   new Path("/home/bhg/git/san/San/src/main/webapp/data/naver/output/recommand/part-r-00000"));
			   fs.close();
			 					
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
	   }

}
