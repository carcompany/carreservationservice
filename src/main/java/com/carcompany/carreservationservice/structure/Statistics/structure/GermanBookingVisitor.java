package com.carcompany.carreservationservice.structure.Statistics.structure;

import com.carcompany.carreservationservice.structure.Payment.structure.SacraficialPaymentProcess;

/**
 * This class implements each operation declared by Visitor. Each operation
 * implements a fragment of the algorithm defined for the corresponding class of
 * object in the structure. ConcreteVisitor provides the context for the algorithm
 * and stores its local state. This state often accumulates results during the
 * traversal of the structure.
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:47
 */
public class GermanBookingVisitor implements BookingVisitor {

	public GermanBookingVisitor(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param concreteElementA
	 */
	public void visit(PayPalExternalPaymentService concreteElementA){

	}

	/**
	 * 
	 * @param concreteElementB
	 */
	public void visit(GooglePayExternalPaymentService concreteElementB){

	}

	/**
	 * 
	 * @param MoneyWallet
	 */
	public void visit(SacraficialPaymentProcess MoneyWallet){

	}
}//end GermanBookingVisitor