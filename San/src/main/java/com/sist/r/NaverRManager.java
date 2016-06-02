package com.sist.r;
import java.util.*;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
@Component
public class NaverRManager {
	public void rGraph(){
		try{
			RConnection rc=new RConnection();			
			rc.voidEval("naver<-read.table(\"/home/sist/git/P3_FinalProject/Fit/src/main/webapp/data/naver/output/part-r-00000\")");			
			rc.voidEval("png(\"/home/sist/git/P3_FinalProject/Fit/src/main/webapp/R/naver.png\",width=900,height=500)");			
			rc.voidEval("par(mfrow=c(1,2))");//그림그리기			
			rc.voidEval("pie(naver$V2,labels=naver$V1,col=rainbow(10))");			
			rc.voidEval("barplot(naver$V2,names.arg=naver$V1d,col=rainbow(10))");			
			rc.voidEval("dev.off()");
			rc.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
