package com.carcompany.carreservationservice.structure.Resource.structure;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:52
 */
public abstract class ResourceDecorator extends Resource {

	protected double price;
	protected Resource resource;
	public Resource m_Resource;

	public ResourceDecorator(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param resource
	 */
	public ResourceDecorator(Resource resource){

	}

	public double getPrice(){
		return 0;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price){

	}
}//end ResourceDecorator