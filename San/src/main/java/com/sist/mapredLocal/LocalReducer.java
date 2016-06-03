package com.sist.mapredLocal;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LocalReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable res=new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		 
		 int sum=0;
		 for(IntWritable v:values){
			 sum+=v.get();//데이터형 변환 정수로			 
		 }
		 res.set(sum);//다시 intwriter로 변환
		 
		 if(sum>2){
			 context.write(key, res);
		 }

	}

}
