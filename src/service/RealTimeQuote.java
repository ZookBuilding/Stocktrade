package service;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import model.Optional;

public class RealTimeQuote {
	 public static void main(String[] args){
		 try {
			 update("2330");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	public static Optional update(String id) throws Exception {
		Optional quote=new Optional(id);
	    // Yahoo奇摩股市台积电 (2330) 的页面URL
	    String url = "https://tw.stock.yahoo.com/quote/"+id;
	    Document document = null;
	    // 使用Jsoup连接到网页并获取文档对象
	    try {
	    	document= Jsoup.connect(url).get();
	        // 使用CSS选择器提取股价数据
		    Element priceElement = document.select("span[class=Fz(32px) Fw(b) Lh(1) Mend(16px) D(f) Ai(c) C($c-trend-up)]").first();
		    Element nameElement=document.select("h1[class=C($c-link-text) Fw(b) Fz(24px) Mend(8px)]").first();
		    if(nameElement!=null) {
		    quote.setStockname(nameElement.text());
		    }
		        
		    if (priceElement != null) {	
		    	quote.setStockprice(Double.parseDouble(priceElement.text()));
		        System.out.println(quote.getStockname()+": " + quote.getStockprice());
		    } 
		    else {
		    	priceElement = document.select("span[class=Fz(32px) Fw(b) Lh(1) Mend(16px) D(f) Ai(c)]").last();	    	
		    	if (priceElement != null) {
		    		quote.setStockprice(Double.parseDouble(priceElement.text()));
		    		System.out.println(quote.getStockname()+": " + quote.getStockprice());
		        	 }
		    	else {
		    		priceElement = document.select("span[class=Fz(32px) Fw(b) Lh(1) Mend(16px) D(f) Ai(c) C($c-trend-down)]").last();	    	
			    	if (priceElement != null) {
			    		quote.setStockprice(Double.parseDouble(priceElement.text()));
			    		System.out.println(quote.getStockname()+": " + quote.getStockprice());
			        	 }
		        	 }	    
		    }
	    }catch (Exception e) {
	    	System.out.println("error");	
	    	JOptionPane.showMessageDialog(null, "無此股票，請重新輸入");
	    }
	    return quote;
	    	 
	    	
	    
	   

	
	}
}


