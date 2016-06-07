package com.sist.r;
import java.util.*;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;
@Component
public class WordCloud {
	public static void main(String arg[]){
		rGraph();
	}
	
	public static void rGraph(){
		try{
			RConnection rc=new RConnection();
			
			rc.voidEval("data<-readLines(\"/home/stellayoon/바탕화면/san.txt\")");			
			System.out.println("zz");
			rc.voidEval("library(KoNLP)");
			System.out.println("zz");
			rc.voidEval("review<-sapply(data,extractNoun,USE.NAMES = F)");
			System.out.println("zz");
			rc.voidEval("word<-table(unlist(review))");			
			System.out.println("zz");
			REXP p=rc.eval("names(head(sort(word,decreasing = T),20))");
			String[] feels=p.asStrings();
			p=rc.eval("head(sort(word,decreasing = T),20)");
			int[] count=p.asIntegers();
			
			for(int i=0; i<feels.length;i++){
				System.out.println(feels[i]);
			System.out.println(count[i]);
			}
			
			rc.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
