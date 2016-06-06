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
import com.sist.mapredSeason.SeasonDriver;
import com.sist.mongo.LocalVO;
import com.sist.mongo.SanDAO;
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
	private NaverRManager nrm;
	
	@Autowired
	private SanDAO dao;
	
	@RequestMapping("main.do")
	public String main_page(Model model) throws Exception{
		
		List<TourDTO> tlist=tmgr.tourYearData();		//1.국내여행동향인원수d
		List<TourDTO> inoutlist=tmgr.tourInOutData();	//2.입국출국인원수	

		
		model.addAttribute("tlist",tlist);
		model.addAttribute("inoutlist",inoutlist);
		
		return "main";
	}

	@RequestMapping("season.do")
	public String season(Model model) {
		
		List<LocalVO> localList=new ArrayList<LocalVO>();
		List<SeasonVO> seasonList=new ArrayList<SeasonVO>();
		
		try{
			List<String> list = navar.naver("등산");	//블로그 검색
			
			String path="/home/actif/git/san/San/src/main/webapp/data/naver/san.txt";
			
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
			seasonList=nrm.rSeasonData();	//계절
			
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
	
	//2.추천페이지_지역선택
	@RequestMapping("recommand_select.do")
	public String recommand_select(HttpServletRequest req) throws Exception{
			
		String type = req.getParameter("type"); 		// 정렬타입
		//req.setAttribute("list", list);      
		      
		return "theme/theme_ajax/recommand_local";
	}
	
			
	@RequestMapping("zone.do")
	public String zone() {
		return "zone/zone";
	}

}
