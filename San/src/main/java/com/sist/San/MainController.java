package com.sist.San;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.data.*;
import com.sist.mapredLocal.LocalDriver;
import com.sist.mapredRec.RecommandDriver;
import com.sist.mapredSeason.RecSeasonDriver;
import com.sist.mapredSeason.SeasonDriver;
import com.sist.mapredThings.ThingsDriver;
import com.sist.mongo.LocalVO;
import com.sist.mongo.SanDAO;
import com.sist.mongo.ThingsVO;
import com.sist.naver.Naver;
import com.sist.r.NaverRManager;
import com.sist.r.SeasonVO;


@Controller
public class MainController {
	
	@Autowired
	private TourManager tmgr;			//메인 첫번째 한국 여행 동향
	
	@Autowired
	private Naver navar;
	@Autowired
	private LocalDriver ld;	
	@Autowired
	private SeasonDriver sd;
	@Autowired
	private RecommandDriver rd;
	@Autowired
	private RecSeasonDriver rsd;
	@Autowired
	private ThingsDriver td;
	
	@Autowired
	private NaverRManager nrm;
	
	@Autowired
	private SanDAO dao;
	
	@RequestMapping("main.do")
	public String main_page(Model model) throws Exception{
		
		//List<TourDTO> tlist=tmgr.tourYearData();		//1.국내여행동향인원수d
		//List<TourDTO> inoutlist=tmgr.tourInOutData();	//2.입국출국인원수	
		
		List<ThingsVO> thingsList=new ArrayList<ThingsVO>();		// 등산 준비물.
		
		try{
			List<String> list = navar.naver("등산 준비물");	//블로그 검색
			
			String path="/home/seo/git/san/San/src/main/webapp/data/naver/things.txt";
			
			File file = new File(path);
			
			if(file.exists()){
				file.delete();
			}
			
			FileWriter fw=new FileWriter(path);
			
			for(String n:list){	
				fw.write(n);	
			}
			fw.close();		

			td.jobCall();
			
			//몽고디비
			thingsList=nrm.rThingsData();		// 준비물
			
			for(ThingsVO r:thingsList)
			{
				ThingsVO tv=new ThingsVO();				
				tv.setThings(r.getThings());					
				tv.setCount(r.getCount());			
				dao.thingsInsert(tv);			// 5이상인 지역만 몽고디비에 저장			
			}
			
			
		}catch(Exception ex){
				System.out.println(ex.getMessage());
		}		
		
		//model.addAttribute("tlist",tlist);
		//model.addAttribute("inoutlist",inoutlist);
		model.addAttribute("thingsList",thingsList);
		return "main";
	}

	@RequestMapping("season.do")
	public String season(Model model) {
		
		List<LocalVO> localList=new ArrayList<LocalVO>();
		List<SeasonVO> seasonList=new ArrayList<SeasonVO>();
		
		try{
			List<String> list = navar.naver("등산");	//블로그 검색
			
			String path="/home/stellayoon/git/san/San/src/main/webapp/data/naver/san.txt";
			
			File file = new File(path);
			
			if(file.exists())
				file.delete();
			
			FileWriter fw=new FileWriter(path);
			
			for(String n:list){		
				fw.write(n);	
			}
			fw.close();		

			ld.jobCall();	
			sd.jobCall();	
			
			//몽고디비
			localList=nrm.rLocalData();		//지역
			seasonList=nrm.rSeasonData(0);	//계절
			
			for(LocalVO r:localList)
			{
				LocalVO lv=new LocalVO();				
				lv.setLocal(r.getLocal());					
				lv.setCount(r.getCount());			
				dao.localInsert(lv);			//7이상인 지역만 몽고디비에 저장			
			}
			
			
		}catch(Exception ex){
				System.out.println(ex.getMessage());
		}		
		
		model.addAttribute("local", localList);		//7개 이상인 지역만 그래프 그리기
		model.addAttribute("season", seasonList);
		
		return "season/season";
	}

	
	//1.추천페이지
	@RequestMapping("theme.do")
	public String theme() {  
	     return "theme/theme";
	}
	
	//2.추천페이지_지역 선택
	@RequestMapping("recommand_select.do")
	public String recommand_select(HttpServletRequest req) throws Exception{
		//부산------------
		//"거문산","구곡산","구덕산","구봉산","구월산","금련산","금정봉","금정산","달음산","마안산","망월산(망월대)","망월산","배산","백양산","백운산","보개산",
		//"봉래산","불광산","산성산","삼각산","석은덤산","수정산","승학산","시명산","아홉산","엄광산","연대봉","용두산","윤산","일광산","장산","철마산","황령산",
		String local = req.getParameter("type"); 		// 지역
		System.out.println(local);
		List<LocalVO> localList=new ArrayList<LocalVO>();
		
		
		try{
			List<String> list = navar.naver(local+" 등산");	//블로그 검색
			
			String path="/home/sist/git/san/San/src/main/webapp/data/naver/localsan.txt";
			
			File file = new File(path);
			
			if(file.exists())
				file.delete();
			
			FileWriter fw=new FileWriter(path);
			
			for(String n:list){		
				fw.write(n);	
			}
			fw.close();		
			
			 if(local.equals("Busan")){
				   System.out.println("busan call");
				   rd.jobCallB();
				   
			   }else if(local.equals("Chungbuk")){
				   System.out.println("Chungbuk call");
				   rd.jobCallC();
			   }//지역
			
			//몽고디비
			localList=nrm.rRecommandData();		//지역
			
			
			for(LocalVO r:localList)
			{
				LocalVO lv=new LocalVO();				
				lv.setLocal(r.getLocal());					
				lv.setCount(r.getCount());			
				dao.localInsert(lv);			//7이상인 지역만 몽고디비에 저장			
			}
			
			
		}catch(Exception ex){
				System.out.println("local: "+ex.getMessage());
		}		
		
		req.setAttribute("recommandlist", localList);      
		      
		return "theme/theme_ajax/recommand_local";
	}
	
	//3.추천페이지_산 선택
	@RequestMapping("recommand_detail.do")
	public String recommand_selectdetail(HttpServletRequest req) throws Exception{
				
		List<SeasonVO> slist=new ArrayList<SeasonVO>();
		
		try{
			
			String san = req.getParameter("san");	//지리산	
			List<String> list = navar.naver(san);	//블로그 검색
			
			String path="/home/sist/git/san/San/src/main/webapp/data/naver/recommand_san.txt";
			
			File file = new File(path);
			if(file.exists())
				file.delete();			
			FileWriter fw=new FileWriter(path);
			for(String n:list){		
				fw.write(n);	
			}
			fw.close();		
			
			rsd.jobCall();
		
			slist=nrm.rSeasonData(1);		//season
					
		}catch(Exception ex){
				System.out.println(ex.getMessage());
		}	
		
		req.setAttribute("slist", slist);      
			      
		return "theme/theme_ajax/recommand_detail";
	}
	
			
	@RequestMapping("zone.do")
	public String zone() {
		return "zone/zone";
	}

}
