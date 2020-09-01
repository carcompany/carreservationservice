package com.carcompany.carreservationservice.structure.resourceservice.structure;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public class ChildSeat extends ResourceDecorator {

	private ChildSeatSize childSeatSize;

	public ChildSeat(Resource resource) {
		super(resource);
	}

	public ChildSeatSize getChildSeatSize() {
		return this.childSeatSize;
	}

	/**
	 * 
	 * @param childSeatSize
	 */
	public void setChildSeatSize(ChildSeatSize childSeatSize) {
		this.childSeatSize = childSeatSize;
	}
}