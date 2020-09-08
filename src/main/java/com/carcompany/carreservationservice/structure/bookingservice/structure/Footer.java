package com.carcompany.carreservationservice.structure.bookingservice.structure;

import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:46
 */
public class Footer {

    private Payment payment;


    public Footer(){


    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    

}