package com.carcompany.carreservationservice.structure.statisticsservice.behaviour;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.EnglishBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.GermanBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.Statistic;

public class StatisticsServiceImplementation extends StatisticsService {

	private GermanBookingVisitor germanStats;
	private EnglishBookingVisitor englishStats;

	public Statistic getGermanBookingsPaidBy(ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		ExternalPaymentService externalPaymentService = null;

		switch (externalPaymentServiceEnumeration) {
			case BANK:
				externalPaymentService = new BankExternalPaymentService();
				break;
			case PAYPAL:
				externalPaymentService = new PayPalExternalPaymentService();
				break;
			case APPLE_PAY:
				externalPaymentService = new ApplePayExternalPaymentService();
				break;
			case GOOGLE_PAY:
				externalPaymentService = new GooglePayExternalPaymentService();
				break;
		}

		SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
		String folderName = format.format(Calendar.getInstance().getTime());

		germanStats = new GermanBookingVisitor(folderName);
		externalPaymentService.accept(germanStats);

		return externalPaymentService;
	}

	public Statistic getEnglishBookingsPaidBy(ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		ExternalPaymentService externalPaymentService = null;

		switch (externalPaymentServiceEnumeration) {
			case BANK:
				externalPaymentService = new BankExternalPaymentService();
				break;
			case PAYPAL:
				externalPaymentService = new PayPalExternalPaymentService();
				break;
			case APPLE_PAY:
				externalPaymentService = new ApplePayExternalPaymentService();
				break;
			case GOOGLE_PAY:
				externalPaymentService = new GooglePayExternalPaymentService();
				break;
		}

		SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
		String folderName = format.format(Calendar.getInstance().getTime());

		englishStats = new EnglishBookingVisitor(folderName);
		externalPaymentService.accept(englishStats);

		return externalPaymentService;
	}
}