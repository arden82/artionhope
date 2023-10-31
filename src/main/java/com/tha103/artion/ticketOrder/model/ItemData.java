package com.tha103.artion.ticketOrder.model;

public class ItemData {
	
	private String selName;
	private String actName;
	private double actTicPrice;
	private int quantity;
	private double subtotal;
	
	public ItemData() {
		super();
	}

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public double getActTicPrice() {
		return actTicPrice;
	}

	public void setActTicPrice(double actTicPrice) {
		this.actTicPrice = actTicPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
