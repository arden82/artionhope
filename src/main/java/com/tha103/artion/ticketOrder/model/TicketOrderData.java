package com.tha103.artion.ticketOrder.model;
//沒有用的東西(皓瑄)
public class TicketOrderData {
	private int selName;
    private String actName;
    private double actTicPrice;
    private int quantity;
    private int subtotal;
    private double totalAmount;
    private int memId;
    
	public TicketOrderData() {
		super();
	}

	public TicketOrderData(int selName, String actName, double actTicPrice, int quantity, int subtotal,
			double totalAmount, int memId) {
		super();
		this.selName = selName;
		this.actName = actName;
		this.actTicPrice = actTicPrice;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.totalAmount = totalAmount;
		this.memId = memId;
	}

	public int getSelName() {
		return selName;
	}

	public void setSelName(int selName) {
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

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}
	
	
	
}
