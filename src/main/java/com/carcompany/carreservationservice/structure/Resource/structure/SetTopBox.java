package com.carcompany.carreservationservice.structure.Resource.structure;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:53
 */
public class SetTopBox extends ResourceDecorator {

	protected double price;
	protected Resource resource;
	private double volume;

	public SetTopBox(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param resource
	 */
	public SetTopBox(Resource resource){

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

	public double getVolume(){
		return 0;
	}

	/**
	 * 
	 * @param volume
	 */
	public void setVolume(double volume){

	}
}//end SetTopBox