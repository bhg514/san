package com.sist.mapredFeel;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FeelMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] feel = {
			"행복","재미","즐거움","상쾌","유쾌","통쾌","가고 싶은","좋[가-힣]","그리운",
			"힘든","힘듦","힘듬","싫음","싫어","우울","절망","별로","다시는","괜히","망설","귀찮",
			"모험","여정","더움","더워","더웠","덥네","추워","춥네","추움","서늘","시원",
			"추천","꼭","반드시","한번쯤",
			"멀긴","먼","가까운","가까워"
	};
	
	Pattern[] pattern=new Pattern[feel.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<feel.length;i++){
			pattern[i]=Pattern.compile(feel[i]);
		}
		
		Matcher[] matcher=new Matcher[feel.length];
		
		for(int i=0;i<feel.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()){
				
				result.set(feel[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}	
	}
}
