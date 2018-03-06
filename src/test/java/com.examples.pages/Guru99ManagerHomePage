package com.examples.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru99.framework.Guru99WebDriverImpl;
import com.examples.config.GlobalDataStore;
public class Guru99ManagerHomePage {

	Guru99WebDriverImpl driver;

	By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	By logOut = By.xpath("//a[@text='Log out']");

	public void setWebDriver(Guru99WebDriverImpl webDriver) {

		this.driver = webDriver;
	

	}

    public Guru99ManagerHomePage(Guru99WebDriverImpl Webdriver){

        this.driver = Webdriver;

    }
    
    public String getHomePageDashboardUserName(){

        return driver.FindElement(homePageUserName).getText();

       }

    


}
