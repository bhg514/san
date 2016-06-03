package com.sist.mapredLocal;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;


public class LocalMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] local = {
			"서울","인천","강화","김포","고양","파주","연천","포천","가평","여주",
			"동두천","양주","의정부","구리","하남","성남","과천","안양","광명",
			"부천","광명","시흥","군포","의왕","안산","수원","화성","오산","평택",
			"안성","용인","이천","광주","여주","양평","남양주","양평","옹진","남양주",
			"부산","대구","광주","대전","울산","세종",
			"철원","화천","양구","고성","인제","속초","양양","홍천","횡성","원주","평창",
			"강릉","정선","동해","삼척","태백","영월","청주",
		    "보은","옥천","영동","진천","괴산","음성","단양","증평",
		    "금산","부여","서천","청양","홍성","예산","태안",
		    "공주","보령","아산","서산","논산","계룡","당진", "천안","전주",		    
		    "군산","익산","정읍","남원","김제","완주","진안","무주","장수","임실","순창","고창","부안",
		    "목포","여수","순천","나주","광양","담양","곡성","구례","고흥","보성","화순","장흥","강진","해남","영암",
		    "무안","함평","영광","장성","완도","진도","신안","경주","김천","안동","구미","영주","영천","상주","문경","경산","포항",
		    "군위","의성","청송","영양","영덕","청도","고령","성주","칠곡","예천","봉화","울진","울릉",
		    "창원","진주","통영","사천","김해","밀양","거제","양산시",
		    "의령","함안","창녕","고성","남해","하동","산청","함양","거창","합천","제주"	
	};
	
	Pattern[] pattern=new Pattern[local.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<local.length;i++){
			pattern[i]=Pattern.compile(local[i]);
		}
		
		Matcher[] matcher=new Matcher[local.length];
		
		for(int i=0;i<local.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()){
				result.set(local[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}	
	}
}
