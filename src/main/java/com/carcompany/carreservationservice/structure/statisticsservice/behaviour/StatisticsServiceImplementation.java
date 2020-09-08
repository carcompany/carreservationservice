package com.carcompany.carreservationservice.structure.statisticsservice.behaviour;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.BookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.EnglishBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.GermanBookingVisitor;

public class StatisticsServiceImplementation extends StatisticsService {
	
	private GermanBookingVisitor germanStats;
	private EnglishBookingVisitor englishStats;
	
	

	public void getGermanBookingsPaidBy(ExternalPaymentService externalPaymentService) {
		
		germanStats = new GermanBookingVisitor("22-09");
		externalPaymentService.accept(germanStats);
	}

	public void getEnglishBookingsPaidBy(ExternalPaymentService externalPaymentService) {
		
		englishStats = new EnglishBookingVisitor();
		
		BookingVisitor visitor = new EnglishBookingVisitor();
		
		externalPaymentService.accept(germanStats);
	}
}