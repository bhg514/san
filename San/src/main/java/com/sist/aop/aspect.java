package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.mapredLocal.LocalDriver;
import com.sist.mapredLocal.LocalReducer;
import com.sist.mapredSeason.SeasonDriver;
import com.sist.mapredThings.ThingsDriver;
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
    
  //2.season
    @Before("execution(* com.sist.mapredThings.ThingsDriver.jobCall())")
    public void beforeThings()
    {
    	td.fileDelete();
    	td.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapredThings.ThingsDriver.jobCall())")
    public void afterThings()
    {
    	td.copyToLocal();
    	//nrm.rGraph();
    }
}




