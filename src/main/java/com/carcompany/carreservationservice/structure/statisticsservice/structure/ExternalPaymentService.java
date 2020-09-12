package com.carcompany.carreservationservice.structure.statisticsservice.structure;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

public abstract class ExternalPaymentService extends ExternalPaymentStatistic {

	public abstract void accept(BookingVisitor bookingVisitor);

}