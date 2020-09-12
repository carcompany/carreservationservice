package com.carcompany.carreservationservice.structure.statisticsservice.structure;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentStatistic;

public interface BookingVisitor {
    void visit(PayPalExternalPaymentStatistic externalPaymentService);

    void visit(ApplePayExternalPaymentStatistic externalPaymentService);

    void visit(GooglePayExternalPaymentStatistic externalPaymentService);

    void visit(BankExternalPaymentStatistic externalPaymentService);
}