package com.carcompany.carreservationservice.structure.bookingservice.structure;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:36
 */
public abstract class Booking {


	static private int numberOfBookings = 1;

	private int id;

	protected Head head;
	protected Body body;
	protected Footer footer;

	Booking(){
		this.id = numberOfBookings;
		incrementNumberOfBookings();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Footer getFooter() {
		return footer;
	}

	public void setFooter(Footer footer) {
		this.footer = footer;
	}


	private void incrementNumberOfBookings(){
		numberOfBookings++;
	}



	




}