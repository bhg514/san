package com.sist.mapredRec;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;

public class Gangwon_RecommandMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	private final IntWritable one=new IntWritable(1);
	private Text result=new Text();
	String[] san={"가덕산","가리봉","가리산","가리왕산","가마봉","가칠봉","각흘산","각희산","간현봉","갈경산",
			"갈기산","감악산","감악삼봉","개인산","거문산","건등산","검각산","검봉산","계관산","계방산","계족산",
			"고고산","고대산","고두산","고루포기산","고양산","곧은봉","곰바위봉","곰배령","곰봉","공룡능선",
			"공작산","광덕산","괘방산","구룡산","구룡산","구봉산","구봉대산","구절산","구학산","국지산","근산",
			"금강산","금당산","금대봉","금물산","금병산","금학산","금확산","기우산","꼭두봉","남대봉","남병산",
			"노목산","노인봉","노추산","뇌암산","능경봉","다락산","단풍산","달마봉","닭이봉","당산","대덕산",
			"대룡산","대암산","대학산","덕가산","덕고산","덕수산","덕항산","도마치봉","도화산","동대산","돼지봉",
			"된불데기산","두루봉","두류산","두위봉","두타산","등선봉","등잔봉","마대산","마산","마적산","망경대산","매봉산",
			"매봉산","매봉산","매봉산","매화산","맹현봉","면산","명봉산","명성산","목우산","몽덕산","무학봉","문수봉",
			"문암산","미륵산","민둥산","바위산","박달봉","박월산","박지산","반암산","발교산","발산","발왕산","방태산",
			"백덕산","백병산","백석봉","백석산","백암산","백우산","백운산","백운산","백운산","백이산","백적산","번암산",
			"범바위봉","벼락바위봉","벽암산","병무산","보래봉","보석봉","복계산","복두산","봉래산","봉복산","봉화산","봉화산",
			"부용산","북배산","비봉산","비산","사금산","사달산","사명산","사자산","삼각봉","삼방산","삼방산","삼봉","삼악산",
			"삽다리봉","삿갓봉","삿갓봉","삿갓봉","상원산","상정바위","새득이봉","샛등봉","석기암산","석두봉","석룡산","석병산",
			"선달산","선바위봉","선바위산","선자령","설악산","성지봉","성치산","소금산","송학산","쇠이봉","수리봉","수리봉",
			"숲뒤산","쉰움산","시루산","신선바위봉","신선봉","십자봉","아리랑산","아미산","안산","약수산","어답산","어라연",
			"연엽산","연화산","오대산","오봉산","오봉산","오음산","옥갑산","완택산","왕터산","용인등봉","용화산","우두산",
			"운교산","운무산","위령산","응복산","응봉산","응봉산","응봉산","잠두산","잣봉","장락산","장미산","장병산","장산",
			"장암산","절개산","점봉산","접산","제왕산","조봉","조양산","종자산","좌방산","주걱봉","주전골","중봉산","중왕산",
			"지각산","지억산","질운산","천삼산","천지봉","청옥산","청옥산","청태산","촛대봉","치바위산","치악산","칠성산",
			"태기산","태백산","태화산","토산","팔봉산","푯대봉","피래산","함백산","향로봉","화란봉","화악산","회령봉","회목봉",
			"회봉산","흘림골","흥정산"};
	
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
