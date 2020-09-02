package com.carcompany.carreservationservice.structure.statisticsservice.structure;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:45
 */
public interface ExternalPaymentService {

	/**
	 * 
	 * @param bookingVisitor
	 */
	public void accept(BookingVisitor bookingVisitor);

}