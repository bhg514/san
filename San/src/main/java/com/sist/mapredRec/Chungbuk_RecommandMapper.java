package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Chungbuk_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"가령산","가섭산","가은산","각호산","갈기산","갈모봉","갈미봉","감악산","감악삼봉","것대산","계명산","계명산","곤천산","구녀산",
			"구담봉","구라산","구병산","구왕봉","구학산","국망봉","국망산","국봉","군자산","금단산","금봉산","금수산","금적산","깃대봉",
			"꼭두바위봉","꽤꼬리봉","낙영산","남군자산","남산","눌의산","대성산","대야산","덕가산","덕가산","덕성산","덕의봉","덕절산","덕주봉","도덕봉",
			"도락산","도명산","도솔봉","돌남산","동산","두악산","두타산","둔주봉","둔지미산","둥지봉","등곡산","떡갈봉","마니산","마대산","마분봉",
			"마성산","마성산","마성산","마역봉","마이산","막장봉","만기봉","만뢰산","만수봉","말목산","망덕봉","망이산","메두막봉",
			"메밀봉","면위산","묘봉","묘적봉","무제봉","문수봉","문안산","미남봉","미인봉","민주지산","박달산","박쥐봉","발치봉","백마산","백악산",
			"백운산","백족산","백하산","백화산","백화산","벼락바위봉","보광산","보련산","보배산","부모산","부산","부용산","북바위산","비봉산",
			"사봉","삼도봉","삼보산","삼봉산","삼태산","상당산","상학봉","서대산","서운산","석기봉","석기암산","석화봉","선미봉","성불산",
			"소백산","소속리산","속리산","송학산","수레의산","수리봉","수리봉","수정산","수주팔봉","승대산","시랑산","시루봉","식장산","신선봉",
			"신선봉","신선암봉","십자봉","아가봉","악휘봉","양성산","양천산","어래산","연내봉","오갑산","옥녀봉","옥순봉","올산","용두산","용마산",
			"용바위봉","용산봉","용암봉","우암산","원통산","월류봉","월악산","월악수리봉","월이산","월항삼봉","월형산","이만봉","이성산","인등산",
			"작성산","작은동산","장미산","장령산","제비봉","조령산","조봉산","조항산","좌구산","주론산","주봉산","주월산","주행봉","중대봉","지등산",
			"지장산","천등산","천삼산","천태산","철봉산","첩푸산","청화산","충북알프스","칠보산","큰산","태화산","팔음산","포성봉","포암산","하설산",
			"함박산","항건산","형제봉","형제봉","홀통골산","환산","환희산","황악산","황정산","황학산","희양산"};
	
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
