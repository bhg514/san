package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Gyeongnam_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"가라산","가야산","가지산","각산","갈전산","감악산","감암산","감투봉","거류산",
			"거망산","건흥산","계룡산","계방산","관룡산","광려산","광제산","괘관산","괘방산","구곡산",
			"구두산","구만산","구인산","구절산","구천산","구천산","구현산","국사봉","국사봉","군지산",
			"굴암산","금귀봉","금대산","금산","금성산","금오산","금오산","금원산","금정산","기백산",
			"깃대봉","낙화산","남덕유산","남산","남산제일봉","노자산","능동산","단지봉","달음산","대곡산",
			"대금산","대방산","대성산","대암산","대운산","덕대산","덕유산","동산","동신어산","두무산","둔철산",
			"마금산","만어산","망산","망산","망운산","망월산","망진산","매봉산","매화산","모산재",
			"무량산","무이산","무척산","무학산","미녀산","미성산","미타산","방어산","배내봉","백두산",
			"백마산","백마산","백운산","백운산","백운산","백월산","벽방산","벽화산","별유산","보개산","보해산",
			"봉림산","봉명산","부암산","북병산","북암산","분성산","불모산","불모산","비계산","비봉산","비음산",
			"사량도지리산","산방산","삼봉산","삼봉산","삼신봉","삼정산","상산","서북산","석대산","석룡산",
			"석은덤산","선자산","설흘산","성제봉","성황산","송의산","수도산","수양산","수태산","승학산",
			"시루봉","시명산","시살등","신어산","쌍봉","아홉산","악견산","앵산","양각산","억산","여항산",
			"연화산","연화산","영남알프스","영축산","영취산","영취산","오도산","오룡산","오봉산","옥교산",
			"옥녀봉","옥녀봉","옥산","와룡산","왕산","용암봉","용지봉","우두산","운문산","운봉산","웅산",
			"웅석봉","원산","월봉산","월아산","월여산","의상봉","이명산","이방산","자굴산","작대산","장복산",
			"장척산","재약산","적벽산","적석산","정각산","정병산","정수산","정안산","정족산","제황산","조두산",
			"종남산","종암산","주산","지룡산","지리산","지리산","집현산","천개산","천마산","천성산",
			"천왕봉","천자봉","천장산","천주산","천태산","천황산","천황산","칠성봉","칠현산","태봉산","토곡산",
			"팔용산","필봉산","한우산","할미봉","함박산","향로봉","향로산","향로봉","허굴산","현금산","현성산",
			"형제봉","호구산","화악산","화왕산","화장산","황매산","황석산","황장산","효렴봉"};
	
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
