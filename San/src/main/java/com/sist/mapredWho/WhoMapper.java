package com.sist.mapredWho;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WhoMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	
	private final IntWritable one = new IntWritable(1);
	private Text result = new Text();
	
	String[] who = {"친구","혼자","홀로","애인","오빠","여자친구","남자친구","자기","여친","남친","가족","엄마","아빠"
			//넣으세요
	};
	Pattern[] pattern = new Pattern[who.length];
	
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<who.length; i++){
			pattern[i] = Pattern.compile(who[i]);
		}
		
		Matcher[] matcher = new Matcher[who.length];
		for(int i=0; i<who.length;i++){
			matcher[i] = pattern[i].matcher(value.toString()); // 값에 패턴내용을 갖고온다.(한줄)
			while(matcher[i].find()){ 
				if(i>=3 && i<10){
					result.set("couple");				//String을 text로 바꿀때 set 사용
				}else if(i>=1&&i<3){
					result.set("solo");
				}else if(i>10){
					result.set("famaily");
				}else{
					result.set("friend"); // 키값 부여
				}
				
				context.write(result, one); // 단어 하나에 1씩 부여
			}
		}
		
		
	}

	
	
}
