package com.carcompany.carreservationservice.structure.Statistics.behaviour;

import com.carcompany.carreservationservice.structure.Statistics.structure.ExternalPaymentService;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:54
 */
public interface StatisticsService {

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void getGermanBookingsPaidBy(ExternalPaymentService externalPaymentService);

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void getEnglishBookingsPaidBy(ExternalPaymentService externalPaymentService);

}