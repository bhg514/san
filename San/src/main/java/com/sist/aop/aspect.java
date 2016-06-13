package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
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

  //3. recommand
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
    
    
    //========================
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




