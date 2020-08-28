package com.carcompany.carreservationservice.structure.Resource.structure;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public class ChildSeat extends ResourceDecorator {

	protected double price;
	protected Resource resource;
	private ChildSeatSize childSeatSize;

	public ChildSeat(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param resource
	 */
	public ChildSeat(Resource resource){

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

	public ChildSeatSize getChildSeatSize(){
		return null;
	}

	/**
	 * 
	 * @param childSeatSize
	 */
	public void setChildSeatSize(ChildSeatSize childSeatSize){

	}
}//end ChildSeat