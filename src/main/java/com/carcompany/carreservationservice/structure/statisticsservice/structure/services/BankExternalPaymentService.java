package com.carcompany.carreservationservice.structure.statisticsservice.structure.services;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.BookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;

public class BankExternalPaymentService extends Statistics implements ExternalPaymentService {

	public BankExternalPaymentService(){

	}

	public void accept(BookingVisitor bookingVisitor){
		bookingVisitor.visit(this);
	}
}