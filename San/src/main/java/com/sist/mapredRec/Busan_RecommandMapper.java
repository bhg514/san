package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Busan_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"거문산","구곡산","구덕산","구봉산","구월산","금련산","금정봉","금정산","달음산","마안산","망월산(망월대)","망월산","배산",
			"백양산","백운산","보개산","봉래산","불광산","산성산","삼각산","석은덤산","수정산","승학산","시명산","아홉산","엄광산","연대봉","용두산",
			"윤산","일광산","장산","철마산","황령산"};
	
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
