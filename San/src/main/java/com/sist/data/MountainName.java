package com.sist.data;
import java.io.*;
import java.util.*;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
 
@Component
public class MountainName {
	 
	public static void main(String arg[]) {
/*		 ga();
		 na();
		 da();
		// ra();
		 ma();
		 ba();
		 sa();
		 a();
		 ja();
		 cha();
		 ka_pa();
		 ha();
		Seoul();
		Incheon();
		Gyeonggi();
		Gangwon();
		Chungbuk();
		Daejeon();
		Daegu();
		Busan();
		Ulsan();
*/		
		gaHeight();
	}
	
	public static void ga(){
			try	{
				String test;
				 
				Document doc=null;
				 
				Elements titleElem=null;
				 
				 
				 
				/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
				if(file.exists())
				file.delete();*/
				 
				FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
				 
				 
				doc=Jsoup.connect("http://www.koreasanha.net/ganada/ga.htm").get();
				titleElem=doc.select("table.tbl tbody tr td ol li");
				
				for(int j=0;j<titleElem.size();j++)	{
				 
					Element telem=titleElem.get(j);	
					test=telem.text()+"\n";
					StringTokenizer st=new StringTokenizer(test, " ");
					//fw.write(test);
					
					 /*
					  * 하설산 1,035m 충북 제천 덕산면
						학가산 870m 경북 안동, 예천
					  */
					//System.out.println(st.nextToken());
					fw.write("\""+st.nextToken()+"\",");
					
					
					
				}
				 
				
				fw.close();
			}catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		
	}
	public static void na(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/na.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void da(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/da.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	/*public static void ra(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ra.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}*/
	public static void ma(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ma.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void ba(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ba.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void sa(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/sa.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void a(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/a.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void ja(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ja.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void cha(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/cha.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void ka_pa(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ka-pa.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void ha(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainName.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ha.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////^ 모든 산
	public static void Seoul(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Seoul.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_seo.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
					
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Incheon(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Incheon.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_ic.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Gyeonggi(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Gyeonggi.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_kg.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Gangwon(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Gangwon.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_kw.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Chungbuk(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Chungbuk.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_cb.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Daejeon(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Daejeon.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_tj.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Chungcheongnam(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Chungcheongnam.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_cn.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Jeonbuk(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Jeonbuk.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_chb.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Daegu(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Daegu.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_tg.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Gyeongbuk(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Gyeongbuk.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_kb.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Busan(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Busan.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_ps.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Gyeongsangnam(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Gyeongsangnam.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_kn.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Ulsan(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Ulsan.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_us.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void Jeju(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/바탕화면/seoul.txt");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/Jeju.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/rg/mt_cj.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////^ 지역별 산
	public static void gaHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ga.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write(st.nextToken()+"\n");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void naHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/na.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void daHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/da.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	/*public static void ra(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ra.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, " ");
				//fw.write(test);
				
				 
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}*/
	public static void maHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ma.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void baHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ba.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void saHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/sa.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void aHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/a.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void jaHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ja.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void chaHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/cha.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void ka_paHeight(){
		try	{
			String test;
			 
			Document doc=null;
			 
			Elements titleElem=null;
			 
			 
			 
			/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
			if(file.exists())
			file.delete();*/
			 
			FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
			 
			 
			doc=Jsoup.connect("http://www.koreasanha.net/ganada/ka-pa.htm").get();
			titleElem=doc.select("table.tbl tbody tr td ol li");
			
			for(int j=0;j<titleElem.size();j++)	{
			 
				Element telem=titleElem.get(j);	
				test=telem.text()+"\n";
				StringTokenizer st=new StringTokenizer(test, "m");
				//fw.write(test);
				
				 /*
				  * 하설산 1,035m 충북 제천 덕산면
					학가산 870m 경북 안동, 예천
				  */
				//System.out.println(st.nextToken());
				fw.write("\""+st.nextToken()+"\",");
				
				
				
			}
			 
			
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	
	}
	public static void haHeight(){
	try	{
		String test;
		 
		Document doc=null;
		 
		Elements titleElem=null;
		 
		 
		 
		/*File file = new File("/home/actif/git/san/San/src/main/webapp/data/MountainName");
		if(file.exists())
		file.delete();*/
		 
		FileWriter fw=new FileWriter("/home/actif/git/san/San/src/main/webapp/data/MountainName/MountainHeight.txt",true);
		 
		 
		doc=Jsoup.connect("http://www.koreasanha.net/ganada/ha.htm").get();
		titleElem=doc.select("table.tbl tbody tr td ol li");
		
		for(int j=0;j<titleElem.size();j++)	{
		 
			Element telem=titleElem.get(j);	
			test=telem.text()+"\n";
			StringTokenizer st=new StringTokenizer(test, "m");
			//fw.write(test);
			
			 /*
			  * 하설산 1,035m 충북 제천 덕산면
				학가산 870m 경북 안동, 예천
			  */
			//System.out.println(st.nextToken());
			fw.write("\""+st.nextToken()+"\",");
			
			
			
		}
		 
		
		fw.close();
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////^  산 높이
	
	
	
	
	 
} 