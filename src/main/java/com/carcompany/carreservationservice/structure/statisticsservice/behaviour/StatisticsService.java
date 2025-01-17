package com.carcompany.carreservationservice.structure.statisticsservice.behaviour;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

public abstract class StatisticsService {

	private static StatisticsServiceImplementation instance;

	public static StatisticsServiceImplementation getInstance() {
		if (instance == null) {
			instance = new StatisticsServiceImplementation();
		}
		return instance;
	}

	public abstract ExternalPaymentStatistic getGermanBookingsPaidBy(
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration);

	public abstract ExternalPaymentStatistic getEnglishBookingsPaidBy(
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration);

}