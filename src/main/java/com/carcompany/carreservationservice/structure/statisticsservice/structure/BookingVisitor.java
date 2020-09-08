package com.carcompany.carreservationservice.structure.statisticsservice.structure;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentService;

public interface BookingVisitor {
    void visit(PayPalExternalPaymentService externalPaymentService);
    void visit(ApplePayExternalPaymentService externalPaymentService);
    void visit(GooglePayExternalPaymentService externalPaymentService);
    void visit(BankExternalPaymentService externalPaymentService);
}