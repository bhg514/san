package com.sist.mapred;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.stereotype.Repository;


public class NaverMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	
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


/*
 * package com.sist.regex;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


^ 문자열의 시작    ^A       A%
$ 문자열의 종료  T$       %T
. 임의의 한 문자 (문자의 종류 가리지 않음)단, \ 는 넣을 수 없음
* 앞 문자가 없을 수도 무한정 많을 수도 있음
+ 앞 문자가 하나 이상
? 앞 문자가 없거나 하나있음
[] 문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타낸다. 
   [A-Z][a-z][0-9][가-핳]
   []내에서 ^가 선행하여 존재하면 not 을 나타낸다.
{} 횟수 또는 범위를 나타낸다.
   ^A[a-z]{1,10}:뒤에 몇글자 오던지 상관안함
   [0-9]{1,3}.[0-9]{1-3}.[0-9]{1-3}.[0-9]{1-3}       => IP주소
() 소괄호 안의 문자를 하나의 문자로 인식 
| 패턴 안에서 or 연산을 수행할 때 사용
\s 공백 문자
\S 공백 문자가 아닌 나머지 문자
\w 알파벳이나 숫자
\W 알파벳이나 숫자를 제외한 문자
\d 숫자 [0-9]와 동일
\D 숫자를 제외한 모든 문자
\ 정규표현식 역슬래시(\)는 확장 문자
 
 
public class RegExMapper extends Mapper<LongWritable, Text, Text, IntWritable>{      //한줄씩 읽어와서 단어별로 1씩 보내줌

   private final IntWritable one=new IntWritable(1);
   private Text result=new Text();
   
   //String regex="([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})";   //ip주소=java는 \\해야 \로 인식
   String regex1="(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";         //ip주소
   
    // 07/Mar/2004:16:23:12
    
   String regex2="\\d{2}/\\w{3}/\\d{4}";    //07/Mar/2004
   String regex3="\\d{2}:\\d{2}:\\d{2}";   //16:23:12
   
   @Override
   protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
         throws IOException, InterruptedException {   //value=한줄씩 읽음
      
      Pattern p=Pattern.compile(regex3);         //ip주소 패턴
      Matcher m=p.matcher(value.toString());      //한줄안에 ip주소가 있는가
      while(m.find()){
         result.set(m.group());      //패턴에 해당하는 실제 ip   //group(1)=> 그룹안에서 1번 단어묶음
         context.write(result, one); //context에 누적해서 reducer로 넘김
      }
      
   }
   
   
   
}
*/
















