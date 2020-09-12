package com.carcompany.carreservationservice.structure.statisticsservice.structure.services;

public abstract class ExternalPaymentStatistic {

	private double paymentSum;
	private int bookingSum;

	public int getBookingSum() {
		return this.bookingSum;
	}

	public void setBookingSum(int bookingSum) {
		this.bookingSum = bookingSum;
	}

	public double getPaymentSum() {
		return this.paymentSum;
	}

	public void setPaymentSum(double paymentSum) {
		this.paymentSum = paymentSum;
	}

}
