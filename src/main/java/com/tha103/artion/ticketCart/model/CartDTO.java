package com.tha103.artion.ticketCart.model;

public class CartDTO {
	private String actId;
	private String actname;
	private String actTicPrice;
	private String memId;

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(String actId, String actname, String actTicPrice, String memId) {
		super();
		this.actId = actId;
		this.actname = actname;
		this.actTicPrice = actTicPrice;
		this.memId = memId;

	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getActname() {
		return actname;
	}

	public void setActname(String actname) {
		this.actname = actname;
	}

	public String getActTicPrice() {
		return actTicPrice;
	}

	public void setActTicPrice(String actTicPrice) {
		this.actTicPrice = actTicPrice;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

}
