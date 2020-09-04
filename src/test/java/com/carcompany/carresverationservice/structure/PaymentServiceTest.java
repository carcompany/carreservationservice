package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentService;
import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentServiceImplementation;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.AppleAccount;

class PaymentServiceTest {
	
	public static PaymentService paymentService;
	
	private static Account senderAccount;
	private static Account receiverAccount;
	private static CurrencyAmount currencyAmount;
	private static PaymentType paymentType;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		paymentService = new PaymentServiceImplementation();
		
		senderAccount = new AppleAccount();
		receiverAccount = new AppleAccount();
		
		currencyAmount = new CurrencyAmount();
		paymentType = PaymentType.APPLE_PAY;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}


	@Test
	void canAmountBePaid() {
		assertDoesNotThrow(() -> paymentService.payAmount(senderAccount, receiverAccount, currencyAmount, paymentType));
	}
}
