package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Jeonbuk_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"강천산","개이빨산","검산","경각산","경수산","경옥봉","고덕산","고리봉","고리봉",
			"고산","고성산","관음봉","관주산","교룡산","구봉산","구성산","깃대봉","나래산","남덕유산",
			"내동산","내변산","내장산","대덕산","대둔산","대부산","대성산","덕두산","덕유산","덕태산","동성산",
			"두승산","마이산","만덕산","만복대","만행산","망주봉","모악산","문덕봉","문수산","미륵산",
			"민주지산","바래봉","방문산","방장산","백련산","백암산","백운산","백하산","변산","복두봉",
			"봉실산","봉화산","부귀산","불명산","산성산","삼도봉","삼봉산","삼봉산","상두산","상산","서방산",
			"석기봉","선각산","선녀봉","선야봉","선운산","설산","성수산","소요산","수양산","안수산","여분산",
			"연석산","영대산","영취산","오봉산","오봉산","오성산","완산칠봉","용골산","우금산","운암산","운장산",
			"원등산","원통산","위봉산","입암산","장군봉","장안산","적상산","종남산","중바위산","중수봉","지리산",
			"천등산","천반산","천호산","천황산","추월산","치마산","치명자산","타관산","팔공산","할미봉","호렙산","회문산"};
	
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
