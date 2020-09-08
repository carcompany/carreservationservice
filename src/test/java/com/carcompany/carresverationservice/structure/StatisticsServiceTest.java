package com.carcompany.carresverationservice.structure;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.carcompany.carreservationservice.structure.statisticsservice.behaviour.StatisticsServiceImplementation;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.EnglishBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.GermanBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentService;

@TestMethodOrder(OrderAnnotation.class)
class StatisticsServiceTest {
	
	StatisticsServiceImplementation statisticsService = StatisticsServiceImplementation.getInstance();
	
	private static GooglePayExternalPaymentService googlePay;
	private static ApplePayExternalPaymentService applePay;
	private static PayPalExternalPaymentService payPal;
	private static BankExternalPaymentService bank;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		

		
		googlePay = new GooglePayExternalPaymentService();
		applePay = new ApplePayExternalPaymentService();
		payPal = new PayPalExternalPaymentService();
		bank = new BankExternalPaymentService();
	}

	@Test
	@Order(1)
	void canGermanPaymentOutOfBookingsBeGathered() {
			
		statisticsService.getGermanBookingsPaidBy(googlePay);
		statisticsService.getGermanBookingsPaidBy(applePay);
		statisticsService.getGermanBookingsPaidBy(payPal);
		statisticsService.getGermanBookingsPaidBy(bank);
		
		
		statisticsService.getEnglishBookingsPaidBy(googlePay);
		statisticsService.getEnglishBookingsPaidBy(applePay);
		statisticsService.getEnglishBookingsPaidBy(payPal);
		statisticsService.getEnglishBookingsPaidBy(bank);
		
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}
}
