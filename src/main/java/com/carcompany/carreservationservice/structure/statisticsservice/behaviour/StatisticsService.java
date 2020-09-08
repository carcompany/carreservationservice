package com.carcompany.carreservationservice.structure.statisticsservice.behaviour;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;

public abstract class StatisticsService {
	
	private static StatisticsServiceImplementation instance;
	
	public static StatisticsServiceImplementation getInstance() {
		if(instance == null) {
			instance = new StatisticsServiceImplementation();
		}
		return instance;
	}
	
	public abstract void getGermanBookingsPaidBy(ExternalPaymentService externalPaymentService);
	public abstract void getEnglishBookingsPaidBy(ExternalPaymentService externalPaymentService);

}