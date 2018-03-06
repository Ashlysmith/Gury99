package com.guru99.framework;

import java.net.MalformedURLException;

public class Guru99WebDriverFactory {
	/***
	 * Get a Web Driver instance.
	 * 
	 * @param BrowserName
	 * @return An instance of a webDriver
	 * @throws MalformedURLException 
	 */

	public static Guru99WebDriverImpl getWebDriverInstance(String BrowserName) throws MalformedURLException {
		// String BrowserName-"fireFox";

		Guru99WebDriverImpl webDriver = new Guru99WebDriverImpl();
		
		if (BrowserName.split(",").length == 1) {
			webDriver.init(BrowserName);
		} else {
			webDriver.initSauceLabs(BrowserName); 
		}

		return webDriver;
	}

}
