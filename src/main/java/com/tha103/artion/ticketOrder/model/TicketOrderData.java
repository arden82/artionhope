package com.tha103.artion.ticketOrder.model;

import java.util.List;

public class TicketOrderData {
	private int selName;
    private String actName;
    private double actTicPrice;
    private int quantity;
    private int subtotal;
    private double totalAmount;
    private int memId;
    private List<ItemData> cartData;
    
	public TicketOrderData() {
		super();
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

	public List<ItemData> getCartData() {
		return cartData;
	}

	public void setCartData(List<ItemData> cartData) {
		this.cartData = cartData;
	}
	
}
