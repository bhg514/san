package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Jeonnam_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"가야산","가지산","가학산","갈두산","갈미봉","강천산","격자봉","계족산",
			"고동산","고성산","구봉산","구수산","국사봉","군유산","궁성산","금골산","금성산","금오산","금전산",
			"깃대봉","내장산","노고단","달마산","덕룡산","덕룡산","도솔봉","독실산","동석산","동악산","두륜산",
			"두봉산","마복산","만덕산","만복대","만연산","모악산","모후산","무등산","문수산","방문산","방장산",
			"백계산","백아산","백암산","백운산","병풍산","병풍산","병풍산","보은산","봉대산","봉대산","봉두산",
			"부용산","불갑산","불태봉","불탄봉","비래산","사자산","산성산","산성산","삼문산","삼비산","삼산",
			"삼인산","상황봉","석문산","설산","수인산","승달산","안양산","양을산","억불산","여계산","여귀산",
			"영취산","오봉산","오봉산","오산","오성산","옹성산","용산","용암산","운월산","월출산",
			"유달산","유치산","은적산","인의산","일림산","입암산","장암산","적대봉","적자산","제석산","제암산",
			"조계산","존제산","종고산","주작산","주지봉","지리산","쫓비산","천관산","천등산","천마산","천봉산",
			"천운산","천태산","천태산","첨찰산","초암산","추월산","축령산","칠락산","태청산","통명산","팔영산","화학산","흑석산","희아산"};
	
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
