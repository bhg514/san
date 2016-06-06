package com.sist.mapredFood;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;
public class FoodMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] food={"말린과일","건과일","견과류","땅콩","아몬드",
			"호두","김밥","버거","소세지","옥수수",
			"떡","황도","곶감","오이","육포",
			"고구마말랭이","홍삼","양갱","과일","밤",
			"고구마","샌드위치","과자","초콜렛","사탕",
			"치즈","에너지바","초코바","미숫가루","계란",
			"달걀","당근","빵","두유","감자",
			"묵","유부초밥","캬라멜","캔디","컵라면",
			"커피","선식","도시락"};
	
	Pattern[] pattern=new Pattern[food.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<food.length;i++){
			pattern[i]=Pattern.compile(food[i]);
		}
		
		Matcher[] matcher=new Matcher[food.length];
		
		for(int i=0;i<food.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()){
				result.set(food[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}
		
		
		
	}
	

}