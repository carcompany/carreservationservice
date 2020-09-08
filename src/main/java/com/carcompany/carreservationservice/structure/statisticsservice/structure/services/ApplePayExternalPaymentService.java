package com.carcompany.carreservationservice.structure.statisticsservice.structure.services;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.BookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;


public class ApplePayExternalPaymentService extends Statistics implements ExternalPaymentService {

	public ApplePayExternalPaymentService(){

	}

	public void accept(BookingVisitor bookingVisitor){
		bookingVisitor.visit(this);
	}
}