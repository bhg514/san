package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Jeju_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"무등산","한라산","단산","사라오름","산굼부리","산방산","성산일출봉",
			"송악산","검은오름","다랑쉬오름","따라비오름","어승생오름","용눈이오름"};
	
	Pattern[] pattern=new Pattern[san.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<san.length;i++){
			pattern[i]=Pattern.compile(san[i]);
		}
		
		Matcher[] matcher=new Matcher[san.length];
		
		for(int i=0;i<san.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			
			while(matcher[i].find()){
				result.set(san[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}
	
	}

}
