package com.carcompany.carreservationservice.structure.Resource.structure;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public abstract class Resource {

	private double price;

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}
}