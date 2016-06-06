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
			"좋[가-힣]","행복","재미","즐거움","상쾌","유쾌","통쾌","가고싶은","그리운",
			"힘든","힘듦","힘듬","싫음","싫어","우울","절망","별로","다시는","괜히","망설","귀찮",
			"모험","여정","시원","아쉬움","이쁜",
			"흐뭇","현기증","무서움","뿌듯","보람","기쁨","지루","대견","조오타","죽겠다","죽겟다","주글거","삭막",
			"힘겹","존좋","아름다움","이쁘","이쁨","들떠","힘내","기분업","기대","포기","어려움","탁 트이다","탁트이다","트이다",
			"뻥뚫","희노애락","매료","최고","환상","열받아","짜증","아쉬운","고생","설렘"
	};
	//흐뭇,힘들,현기증무서움,뿌듯,보람,기쁨,지루,대견,조오타,죽겟다,삭막,힘겹다,재미,존좋,아름다움,이쁨,들뜨다,힘내,기분업,기대,포기,어려움,야호,탁트이다,뻥뚤린다,희노애락,매료,최고,환상,열받아,짜증
	//아쉬운, 고생,설렘
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
				
				if(i==0) result.set("좋음");
				else result.set(feel[i]);				//String을 text로 바꿀때 set 사용
				context.write(result, one);
				
			}
		}	
	}
}
