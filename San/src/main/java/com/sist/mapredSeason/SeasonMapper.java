package com.sist.mapredSeason;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class SeasonMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] season={ "봄","여름","가을","겨울" };
	
	Pattern[] pattern=new Pattern[season.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<season.length;i++){
			pattern[i]=Pattern.compile(season[i]);
		}
		
		Matcher[] matcher=new Matcher[season.length];
		
		for(int i=0;i<season.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()){
				result.set(season[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}
		
		
		
	}
	

}
