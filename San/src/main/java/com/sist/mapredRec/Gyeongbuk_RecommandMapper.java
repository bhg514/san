package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Gyeongbuk_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"가산","가야산","가지산","각화산","갈라산","갈모봉","갑장산","갓바위산","검마산",
			"계명산","고헌산","고깔산","고당산","고불봉","곰넘이봉","공덕산","관문산","괘령산","구룡산",
			"구미산","구왕봉","국망봉","국사봉","국수산","귀천봉","금곡산","금봉산","금성산","금오산",
			"금학산","기룡산","기양산","꼭두바위봉","까치산","나각산","남산","남산","남산","남암산",
			"낭산","내연산","냉산","노음산","뇌정산","눌의산","단산","단석산","단지봉","대덕산",
			"대둔산","대미산","대야산","대왕산","덕가산","덕암산","덤산","도덕산","도솔봉","도장산",
			"독용산","동대봉산","동대산","동학산","둔덕산","등운산","막장봉","만리봉","매봉","매봉",
			"매봉산","매악산","맹동산","면봉산","묘봉","무장산","문복산","문봉재","문수봉","문수산",
			"문수산","문수산","민주지산","바데산","방가산","방울암산","방음산581m","백마산","백악산",
			"백암산","백원산","백자산","백화산","백화산","벽도산","병풍산","병풍산","보현산","복두산",
			"복우산","봉명산","봉서산","봉좌산","봉화봉","봉황산","부봉","부용봉","비룡산","비룡산",
			"비룡산","비봉산","비봉산","비봉산","비봉산","비슬산","비학산","사룡산","사림봉","삼도봉",
			"삼방산","삼봉산","삼성산","삼성산","삼태봉","삿갓봉","상운산","상학봉","서산","선달산",
			"선도산","선석산","선암산","선암산","선의산","성암산","성인봉","성주봉","성주봉",
			"소백산","속리산","수도산","수석봉","수선산","수정봉","승무산","시루봉","시루봉","식산",
			"쌍두봉","아기산","애기암봉","아미산","어래산","어룡산","어림산","억산","연엽산","연점산",
			"영암산","오봉산","오봉산","오정산","옥녀봉","옥석산","옥주봉","옹강산","와룡산","왕모산","왕의산",
			"용각산","용당산","용림산","용문산","용산","우미산","운달산","운문산","운제산","운주산","울련산",
			"월방산","유학산","육화산","응봉산","이만봉","인내산","일월산","자옥산","작약산","작약산",
			"장군봉","장륙산","장성봉","절뒤산","정족산","조령산","조록바위봉","조항산","조항산","조화봉",
			"주산","주왕산","주행봉","주흘산","중대봉","중대산","지룡산","지장산","진늪산","천령산",
			"천마산","천봉산","천생산","천주산","천지갑산","천축산","천택산","철마산","철암산","청계산",
			"청량산","청옥산","청화산","촛대봉","치술령","칠보산","칠봉산","침곡산","태백산","태양산",
			"토봉","토함산","통고산","통내산","팔각산","팔공산","팔음산","포성봉","포암산","학가산",
			"학일산","함월산","해월봉","향로봉","현령산","형제봉","형제봉","형제산","홍두깨산","화악산",
			"황계산","황악산","황장산","황학산","흑응산","희양산"};
	
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
