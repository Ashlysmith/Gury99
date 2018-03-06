package com.guru99.framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public interface Guru99WebDriver {
	void init(String Browser);
	void initSauceLabs(String Browser);
	Boolean navigateTo(final String relativeURL);
	 void sendKeys(WebElement element, String name);
	   
	   void clickElement(WebElement element);
	 
	   void acceptPopAlert();
	   WebElement FindElement(By element );
	   
	   public List<WebElement> FindElements(By element);
	    /**
	     * Quits the web driver.
	     */
	    void quitDriver();
	
	    //closes browser window    
	    void closeBrowser();
}
