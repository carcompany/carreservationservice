package com.carcompany.carreservationservice.structure.resourceservice.structure;

/**
 * @author Kevin
 * @version 1.1
 * @created 28-Aug-2020 17:10:53
 */
public class SetTopBox extends ResourceDecorator {

	private double volume;

	public SetTopBox(Resource resource) {
		super(resource);
	}

	public double getVolume() {
		return this.volume;
	}

	/**
	 * 
	 * @param volume
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
}// end SetTopBox