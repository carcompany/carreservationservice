package com.carcompany.carreservationservice.structure.Payment.structure;

import com.carcompany.carreservationservice.structure.Payment.domainvalue.CurrencyAmount;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public enum Currency {
	USD,
	EUR;

	public CurrencyAmount m_CurrencyAmount;
}