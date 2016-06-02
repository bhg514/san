package com.sist.data;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;



@Component
public class TourManager {

	 public List<TourDTO> tourYearData()
	   {
		 	List<TourDTO> list=new ArrayList<TourDTO>(); 
		   try
		   {
			   System.out.println("tourYearData진입-------ddd----------");
			   Document doc=Jsoup.connect("http://www.index.go.kr/potal/main/EachDtlPageDetail.do?idx_cd=1652").get();
			  
			   Elements yearElem=doc.select("table#t_Table_165201 thead tr th");	//년도 2006-2014
			   Elements totalElem=doc.select("table#t_Table_165201 tbody tr#tr_165201_1 td");	//년도별 국ddd내여행 인원수
			   Elements sleepElem=doc.select("table#t_Table_165201 tbody tr#tr_165201_2 td");	//년도별 숙박여행 인원수
			   Elements onedayElem=doc.select("table#t_Table_165201 tbody tr#tr_165201_3 td");	//년도별 당일여행 인원수
			   System.out.println("size:"+totalElem.size());
			   
			   //String[] color={"#b87333","silver","gold","#e5e4e2","#CCFFCC","#CCCCFF","#EDEDED"};
			   
			   for(int i=0; i<totalElem.size(); i++)
			   {
				   Element yearEm=yearElem.get(i+1);
				   Element totalEm=totalElem.get(i);
				   Element sleepEm=sleepElem.get(i);
				   Element onedayEm=onedayElem.get(i);
				   				   
				   TourDTO t=new TourDTO();
				   t.setYear(Integer.parseInt(yearEm.text()));
				   t.setTotal(Integer.parseInt(totalEm.text().replace(",","")));
				   t.setSleep(Integer.parseInt(sleepEm.text().replace(",","")));
				   t.setOneday(Integer.parseInt(onedayEm.text().replace(",","")));
				   
				   list.add(t);
			   }
			   			   
		   }catch(Exception ex)
		   {
			   System.out.println("MovieManager에러:"+ex.getMessage());
		   }
		   
		   return list;
	   }
		   
		   
	public List<TourDTO> tourInOutData()
	   {
		 	List<TourDTO> list=new ArrayList<TourDTO>(); 
		   try
		   {
			   System.out.println("tourInOutData진입----------------");
			   Document doc=Jsoup.connect("http://www.index.go.kr/potal/main/EachDtlPageDetail.do?idx_cd=1655").get();
			   Elements outElem=doc.select("table#t_Table_165501 tbody tr#tr_165501_1 td");	//내국인출국인원수(2006-2014)
			   Elements yearElem=doc.select("table#t_Table_165501 thead tr#trHeader165501_1 th");	//년도 2006-2014
			   
			   Document doc1=Jsoup.connect("http://www.index.go.kr/potal/main/EachDtlPageDetail.do?idx_cd=1653").get();
			   Elements inElem=doc1.select("table#t_Table_165301 tbody tr#tr_165301_1 td");	//외국인입국인원수(2006-2014)
			   
			  System.out.println(yearElem.size());
			  
			   for(int i=0; i<outElem.size(); i++)
			   {
				   Element outEm=outElem.get(i);	
				   String a=outEm.text().replace(",","");
				   String b=a.substring(0, a.lastIndexOf('.'));
				   System.out.println("1. "+b);
				   int outemp=Integer.parseInt(b);
				   int out=outemp*10;					//단위천만에 맞추려고
				   System.out.println("2. "+out);
				   
				   Element yearEm=yearElem.get(i+1);	//년도
				   System.out.println("3. ");
				   
				   Element inEm=inElem.get(i);	
				   String a1=inEm.text().replace(",","");
				   int in=Integer.parseInt(a1);
				   System.out.println("out결과:"+out+",in결과:"+in+", year:"+yearEm.text());
				   
				   TourDTO inoutkor=new TourDTO();
				   inoutkor.setTotal(out);			//1. 내국인 출국인원수(만명)
				   inoutkor.setSleep(in); 			//2. 외국인 입국인원수(천명) 
				   inoutkor.setYear(Integer.parseInt(yearEm.text()));		//3.year
				   System.out.println(inoutkor.getYear());
				   			
				   list.add(inoutkor);
				   
			   }
			   			   
		   }catch(Exception ex)
		   {
			   System.out.println("tourInOutData에러:"+ex.getMessage());
		   }
		   
		   return list;
	   }
}
