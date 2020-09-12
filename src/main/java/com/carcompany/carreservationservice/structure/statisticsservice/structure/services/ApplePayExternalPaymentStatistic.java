package com.carcompany.carreservationservice.structure.statisticsservice.structure.services;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.BookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;

public class ApplePayExternalPaymentStatistic extends ExternalPaymentService {

	public ApplePayExternalPaymentStatistic() {

	}

	public void accept(BookingVisitor bookingVisitor) {
		bookingVisitor.visit(this);
	}
}