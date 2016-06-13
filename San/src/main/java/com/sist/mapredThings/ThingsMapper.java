package com.sist.mapredThings;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ThingsMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] things={ "물","생수","음료수","음료","커피","탄산","탄산음료",		//음료(7)
			"음식","간식","오이","도시락","비상식량","라면","과일","비상식량",		//음식(8)
			"다목적칼","칼","맥가이버","다용도칼",								//다용도칼(4)
			"자켓","자킷","바람막이","방수재킷","에어자켓",						//바람막이(5)			
			"보온조끼","방한 자켓","방한 패딩","방한 점퍼","방한점퍼",
			"방한패딩","방한자켓","핫팩","발난로",
			"손난로","담요","방한 양말","워머","방한 장갑","방한 마스크",
			"마스크","[가-힣]마스크",												//보온용품(18)	
			"의약품","비상약","상비약","대일밴드","반창고","마데카솔",				//비상약(6)
			"벌레퇴치용 스프레이","벌레퇴치밴드","벌레퇴치","모기약","에프킬라","모기향"	,	//벌레퇴치 용품(6)
			"모자","등산모자","등산모","방한모",									//등산모(4)
			"장갑","등산장갑","방한 장갑",										//등산장갑(3)
			"등산 양말","여분 양말","양말",										//여분양말(3)
			"우산","우비","우의",												//우천용품(3)
			"스틱",												//등산스틱(2)
			"등산화","보조밧줄",
			"선글라스","보온병","선크림","삼각끈","배낭",
			"손전등","전등",
			"손수건","화장지","물티슈","돗자리","패드","간이방석","간이의자",
			"종이컵","스틸컵","컵","수저","쓰레기봉투",
			"아이스팩",
			"나침반","지도","스패츠","아이젠",
			"카메라"
			};
	
	Pattern[] pattern=new Pattern[things.length];
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(int i=0; i<things.length;i++){
			pattern[i]=Pattern.compile(things[i]);
		}
		
		Matcher[] matcher=new Matcher[things.length];
		
		for(int i=0;i<things.length;i++){
			matcher[i]=pattern[i].matcher(value.toString());
			while(matcher[i].find()){
				if(i>=0 && i<7){
					result.set("음료및식수");				//String을 text로 바꿀때 set 사용
				}else if(i>=7 && i<13){
					result.set("음식및간식");
				}else if(i>=13 && i<17){
					result.set("다용도칼");
				}else if(i>=17 && i<22){
					result.set("가벼운자켓류");
				}else if(i>=22 && i<40){
					result.set("보온용품");
				}else if(i>=40 && i<46){
					result.set("비상약");
				}else if(i>=46 && i<52){result.set("등산스틱");
					result.set("벌레퇴치용품");
				}else if(i>=52 && i<56){
					result.set("등산모");
				}else if(i>=56 && i<59){
					result.set("등산장갑");
				}else if(i>=59 && i<62){
					result.set("여분양말");
				}else if(i>=62 && i<65){
					result.set("우천시용품");
				}else if(i>=65 && i<66){
					result.set("등산스틱");
				}else{
					result.set(things[i]);
				}
				context.write(result, one);
			}
		}		
	}
}
