package com.carcompany.carreservationservice.structure.statisticsservice.structure;

/**
 * This class implements each operation declared by Visitor. Each operation
 * implements a fragment of the algorithm defined for the corresponding class of
 * object in the structure. ConcreteVisitor provides the context for the algorithm
 * and stores its local state. This state often accumulates results during the
 * traversal of the structure.
 * @author Sebastian, Kevin
 * @version 1.1
 * @created 28-Aug-2020 17:10:47
 */
public class EnglishBookingVisitor implements BookingVisitor {

	public EnglishBookingVisitor(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(PayPalExternalPaymentService externalPaymentService) {

	}
	
	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(ApplePayExternalPaymentService externalPaymentService) {

	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(GooglePayExternalPaymentService externalPaymentService) {

	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(BankExternalPaymentService externalPaymentService) {

	}
}//end EnglishBookingVisitor