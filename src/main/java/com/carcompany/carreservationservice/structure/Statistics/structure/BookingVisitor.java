package com.carcompany.carreservationservice.structure.Statistics.structure;

interface BookingVisitor {
    void visit(PayPalExternalPaymentService externalPaymentService);
    void visit(ApplePayExternalPaymentService externalPaymentService);
    void visit(GooglePayExternalPaymentService externalPaymentService);
    void visit(BankExternalPaymentService externalPaymentService);
}