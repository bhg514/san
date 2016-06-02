package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.mapred.NaverDriver;
import com.sist.mapred.NaverReducer;
import com.sist.r.NaverRManager;
@Aspect
@Component
public class aspect {
	@Autowired
	private NaverDriver nd;
	@Autowired
	private NaverRManager nrm;
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
    	nrm.rGraph();
    }
}




