package com.sist.San;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.data.*;
import com.sist.mapred.NaverDriver;
import com.sist.mapredSeason.SeasonDriver;
import com.sist.naver.Naver;
import com.sist.r.NaverRManager;


@Controller
public class MainController {
	
	@Autowired
	private TourManager tmgr;			//메인 첫번째 한국 여행 동향
	@Autowired
	private Naver navar;
	@Autowired
	private NaverDriver nd;
	
	@Autowired
	private SeasonDriver sd;
	
	@Autowired
	private NaverRManager nrm;
	
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
		
		try{
			List<String> list = navar.naver("등산");	//블로그 검색
			
			String path="/home/sist/git/san/San/src/main/webapp/data/naver/san.txt";
			
			File file = new File(path);
			
			if(file.exists())
				file.delete();
			
			FileWriter fw=new FileWriter(path);
			
			for(String n:list){		
				fw.write(n);	
			}
			fw.close();		

			nd.jobCall();	
			sd.jobCall();	
			
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}		
		
		return "season/season";
	}

	@RequestMapping("theme.do")
	public String theme() {
		return "theme/theme";
	}
	
	@RequestMapping("zone.do")
	public String zone() {
		return "zone/zone";
	}

}
