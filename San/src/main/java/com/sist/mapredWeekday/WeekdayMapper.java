package com.sist.mapredWeekday;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WeekdayMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] weekday={ "월요","화요","수요","목요","금요","토요","일요"};
	
	Pattern[] pattern=new Pattern[weekday.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<weekday.length;i++){
			pattern[i]=Pattern.compile(weekday[i]);
		}
		
		Matcher[] matcher=new Matcher[weekday.length];
		
		for(int i=0;i<weekday.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()){
				
				result.set(weekday[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}
		
		
		
	}
	

}
