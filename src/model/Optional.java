package model;

public class Optional {
	String username;
	String stockid;
	String stockname;
	Double stockprice;
	public Optional(String username,String stockid){
		this.username=username;
		this.stockid=stockid;		
	}
	public Optional(String stokeid){
		this.stockid=stokeid;		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStockid() {
		return stockid;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public Double getStockprice() {
		return stockprice;
	}
	public void setStockprice(Double stockprice) {
		this.stockprice = stockprice;
	}
	
	

	
	
}
