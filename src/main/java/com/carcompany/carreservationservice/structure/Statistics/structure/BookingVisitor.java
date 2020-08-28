package com.carcompany.carreservationservice.structure.Statistics.structure;

interface BookingVisitor {
    void visit(PayPalExternalPaymentService paypal);
}