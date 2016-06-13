package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Chungnam_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"가야산","갑하산","계룡산","고불산","광덕산","금오산","대둔산","덕숭산",
			"도고산","도덕봉","도비산","만수산","만인산","망경산","무성산","바랑산","백마산",
			"백암산","백월산","백화산","봉서산","봉수산","봉수산","상왕산","서대산","석문봉",
			"선야봉","설화산","성거산","성주산","수덕산","아미산635m","아미산","영인산","오서산",
			"옥녀봉","옥마산","옥양봉","용봉산","우산봉","운주산","월성산","위례산","은석산","일락산",
			"일봉산","작성산","진악산","천방산","천태산","천호봉","칠갑산","태조산","태학산","태화산","팔봉산","흑성산","희리산"
	};
	
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
