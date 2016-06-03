package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.mapred.NaverDriver;
import com.sist.mapred.NaverReducer;
import com.sist.mapredSeason.SeasonDriver;
import com.sist.r.NaverRManager;
@Aspect
@Component
public class aspect {
	
	@Autowired
	private NaverDriver nd;
	
	@Autowired
	private SeasonDriver sd;
	
	@Autowired
	private NaverRManager nrm;
	
	//1.weekday
    @Before("execution(* com.sist.mapred.NaverDriver.jobCall())")
    public void before()
    {
    	nd.fileDelete();
    	nd.copyFromLocal();
    }
    
    @After("execution(* com.sist.mapred.NaverDriver.jobCall())")
    public void after()
    {
    	nd.copyToLocal();
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
}




