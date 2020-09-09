package com.carcompany.carreservationservice.structure.statisticsservice.structure.services;

public abstract class Statistics {
	
	private double paymentSum;
	private int bookingSum;
	
	public int getBookingSum() {
		return bookingSum;
	}
	
	public void setBookingSum(int bookingSum) {
		this.bookingSum = bookingSum;
	}
	
	public double getPaymentSum() {
		return paymentSum;
	}
	
	public void setPaymentSum(double paymentSum) {
		this.paymentSum = paymentSum;
	}

}
