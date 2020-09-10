package com.carcompany.carreservationservice.structure.statisticsservice.structure;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.Statistic;

public abstract class ExternalPaymentService extends Statistic {

	public abstract void accept(BookingVisitor bookingVisitor);

}