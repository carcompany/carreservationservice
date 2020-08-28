package com.carcompany.consoleconnector;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:42
 */
public enum CommandEnumeration {
	CREATE_PERSON,
	CREATE_RESOURCE,
	CREATE_BOOKING,
	DELETE_PERSON,
	DELETE_RESOURCE,
	AUTHENTICATE_PERSON,
	PAY_BOOKING,
	SHOW_BOOKINGS,
	SHOW_RESOURCE,
	SHOW_STATISTICS;

	public Dispatcher m_Dispatcher;
}