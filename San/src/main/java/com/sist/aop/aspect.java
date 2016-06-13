package com.sist.aop;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.mapreduce.JobRunner;
import org.springframework.stereotype.Component;

import com.sist.mapredFeel.FeelDriver;
import com.sist.mapredFood.FoodDriver;
import com.sist.mapredLocal.LocalDriver;
import com.sist.mapredRec.RecommandDriver;
import com.sist.mapredSeason.RecSeasonDriver;
import com.sist.mapredSeason.SeasonDriver;
import com.sist.mapredThings.ThingsDriver;
import com.sist.mapredWeekday.WeekdayDriver;
import com.sist.r.NaverRManager;
@Aspect
@Component
public class aspect {
	
	@Autowired
	private LocalDriver ld;
	
	@Autowired
	private SeasonDriver sd;
	
	@Autowired
	private ThingsDriver td;
	@Autowired
	private RecommandDriver rd;
	
	@Autowired
	private RecSeasonDriver rsd;

	@Autowired
	private FeelDriver	fd;
	
	@Autowired
	private WeekdayDriver wd;
	@Autowired
	private FoodDriver foodDriver;
	@Autowired
	private NaverRManager nrm;

	//1.weekday
    @Before("execution(* com.sist.mapredLocal.LocalDriver.jobCall())")
    public void before()
    {
    	ld.fileDelete();
    	ld.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredLocal.LocalDriver.jobCall())")
    public void after()
    {
    	ld.copyToLocal();
    	//nrm.rGraph();
    }
    
    
    //2.season
    @Before("execution(* com.sist.mapredSeason.SeasonDriver.jobCall())")
    public void beforeSeason()
    {
    	sd.fileDelete();
    	sd.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredSeason.SeasonDriver.jobCall())")
    public void afterSeason()
    {
    	sd.copyToLocal();
    	//nrm.rGraph();
    }
   
    
    //3. recommand     ------------------------------------------------------------------------------------------- 
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallB())")
    public void beforeRecommandB()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallB())")
    public void afterRecommandB()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallC())")
    public void beforeRecommandC()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }  
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallC())")
    public void afterRecommandC()
    {
    	rd.copyToLocal();
    }

    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallCN())")
    public void beforeRecommandCN()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallCN())")
    public void afterRecommandCN()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallDJ())")
    public void beforeRecommandDJ()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallDJ())")
    public void afterRecommandDJ()
    {
    	rd.copyToLocal();
    }
    
   
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallDG())")
    public void beforeRecommandDG()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallDG())")
    public void afterRecommandDG()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallGW())")
    public void beforeRecommandGW()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallGW())")
    public void afterRecommandGW()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallGB())")
    public void beforeRecommandGB()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallGB())")
    public void afterRecommandGB()
    {
    	rd.copyToLocal();
    }
    
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallGN())")
    public void beforeRecommandGN()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallGN())")
    public void afterRecommandGN()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallGG())")
    public void beforeRecommandGG()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallGG())")
    public void afterRecommandGG()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallIC())")
    public void beforeRecommandIC()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallIC())")
    public void afterRecommandIC()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallJJ())")
    public void beforeRecommandJJ()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallJJ())")
    public void afterRecommandJJ()
    {
    	rd.copyToLocal();
    }

    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallJB())")
    public void beforeRecommandJB()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallJB())")
    public void afterRecommandJB()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallJN())")
    public void beforeRecommandJN()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }     
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallJN())")
    public void afterRecommandJN()
    {
    	rd.copyToLocal();
    }
    
    @Before("execution(* com.sist.mapredRec.RecommandDriver.jobCallUS())")
    public void beforeRecommandUS()
    {
    	rd.fileDelete();
    	rd.copyFromLocal();
    }    
    @After("execution(* com.sist.mapredRec.RecommandDriver.jobCallUS())")
    public void afterRecommandUS()
    {
    	rd.copyToLocal();
    }
    
    //===================================================================================================================
    //4.recommand_season
    @Before("execution(* com.sist.mapredSeason.RecSeasonDriver.jobCall())")
    public void beforeRecSeason()
    {
    	rsd.fileDelete();
    	rsd.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredSeason.RecSeasonDriver.jobCall())")
    public void afterRecSeason()
    {
    	rsd.copyToLocal();
    	//nrm.rGraph();
    }
  
    
    //5.Weekday
    @Before("execution(* com.sist.mapredWeekday.WeekdayDriver.jobCall())")
    public void beforeWeekday()
    {
    	wd.fileDelete();
    	wd.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredWeekday.WeekdayDriver.jobCall())")
    public void afterWeekday()
    {
    	wd.copyToLocal();
    	//nrm.rGraph();
    }
    
    //6.Feel
    @Before("execution(* com.sist.mapredFeel.FeelDriver.jobCall())")
    public void beforeFeel()
    {
    	fd.fileDelete();
    	fd.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredFeel.FeelDriver.jobCall())")
    public void afterFeel()
    {
    	fd.copyToLocal();
    	//nrm.rGraph();
    }
    //7.food
    @Before("execution(* com.sist.mapredFood.FoodDriver.jobCall())")
    public void beforeFood()
    {
    	foodDriver.fileDelete();
    	foodDriver.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredFood.FoodDriver.jobCall())")
    public void afterFood()
    {
    	foodDriver.copyToLocal();
    	//nrm.rGraph();
    }
    //8.food
    @Before("execution(* com.sist.mapredThings.ThingsDriver.jobCall())")
    public void beforethings()
    {
    	td.fileDelete();
    	td.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredThings.ThingsDriver.jobCall())")
    public void afterthings()
    {
    	td.copyToLocal();
    	//nrm.rGraph();
    }
    
    
}
//


