package com.carcompany.carreservationservice.structure.statisticsservice.behaviour;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.carcompany.carreservationservice.structure.statisticsservice.structure.EnglishBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.GermanBookingVisitor;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

public class StatisticsServiceImplementation extends StatisticsService {

	private GermanBookingVisitor germanStats;
	private EnglishBookingVisitor englishStats;

	public ExternalPaymentStatistic getGermanBookingsPaidBy(
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		ExternalPaymentService externalPaymentService = null;

		switch (externalPaymentServiceEnumeration) {
			case BANK:
				externalPaymentService = new BankExternalPaymentStatistic();
				break;
			case PAYPAL:
				externalPaymentService = new PayPalExternalPaymentStatistic();
				break;
			case APPLE_PAY:
				externalPaymentService = new ApplePayExternalPaymentStatistic();
				break;
			case GOOGLE_PAY:
				externalPaymentService = new GooglePayExternalPaymentStatistic();
				break;
		}

		SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
		String folderName = "/" + format.format(Calendar.getInstance().getTime());

		germanStats = new GermanBookingVisitor(folderName);
		externalPaymentService.accept(germanStats);

		return externalPaymentService;
	}

	public ExternalPaymentStatistic getEnglishBookingsPaidBy(
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		ExternalPaymentService externalPaymentService = null;

		switch (externalPaymentServiceEnumeration) {
			case BANK:
				externalPaymentService = new BankExternalPaymentStatistic();
				break;
			case PAYPAL:
				externalPaymentService = new PayPalExternalPaymentStatistic();
				break;
			case APPLE_PAY:
				externalPaymentService = new ApplePayExternalPaymentStatistic();
				break;
			case GOOGLE_PAY:
				externalPaymentService = new GooglePayExternalPaymentStatistic();
				break;
		}

		SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
		String folderName = "/" + format.format(Calendar.getInstance().getTime());

		englishStats = new EnglishBookingVisitor(folderName);
		externalPaymentService.accept(englishStats);

		return externalPaymentService;
	}
}