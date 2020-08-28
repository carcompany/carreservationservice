package com.carcompany.consoleconnector.view;

import com.carcompany.consoleconnector.Subscriber;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:55
 */
public abstract class View implements Subscriber {

	public View(){

	}

	public void finalize() throws Throwable {

	}
	public abstract void print();

	public abstract void update();
}//end View