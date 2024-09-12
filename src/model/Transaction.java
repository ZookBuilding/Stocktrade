package model;

public class Transaction {
	private String username;
	private String date;
	private String stockid;
	private Double stockprice;
	private Integer stocknumber;
	public Transaction(String username,String date,String stockid,Double stockprice,Integer stocknumber){
		this.username=username;
		this.date=date;
		this.stockid=stockid;
		this.stockprice=stockprice;
		this.stocknumber=stocknumber;
		
	}
	public Transaction(String username){
		this.username=username;
	}
	
	public String getUsername() {
		return username;
	}
	public String getDate() {
		return date;
	}
	public String getStockid() {
		return stockid;
	}
	public Double getStockprice() {
		return stockprice;
	}
	public Integer getStocknumber() {
		return stocknumber;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setStockid(String stockid) {
		this.stockid = stockid;
	}
	public void setStockprice(Double stockprice) {
		this.stockprice = stockprice;
	}
	public void setStocknumber(Integer stocknumber) {
		this.stocknumber = stocknumber;
	}
	
	

	
	
	
	
	

}
