package com.carcompany.carreservationservice.structure.contentservice.structure;

import java.util.HashMap;
import java.util.Map;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;

public class Report extends Content {
    private Map<PaymentType, Double> paymentNumbers;
    private Map<PaymentType, Integer> bookingNumbers;

    public Report() {
        paymentNumbers = new HashMap<>();
        bookingNumbers = new HashMap<>();
    }

    public void increment(PaymentType paymentType, CurrencyAmount currencyAmount) {
        Double value = paymentNumbers.get(paymentType);
        if (value == null)
            paymentNumbers.put(paymentType, currencyAmount.getAmount());
        else
            paymentNumbers.put(paymentType, value + currencyAmount.getAmount());
    }

    public void increment(PaymentType paymentType) {
        Integer value = bookingNumbers.get(paymentType);
        if (value == null)
            bookingNumbers.put(paymentType, 1);
        else
            bookingNumbers.put(paymentType, value + 1);
    }

    public double getPaymentNumbers(PaymentType paymentType) {
        return paymentNumbers.get(paymentType);
    }

    public int getBookingNumbers(PaymentType paymentType) {
        return bookingNumbers.get(paymentType);
    }

}
