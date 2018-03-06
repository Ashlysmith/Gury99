package com.examples.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.guru99.framework.Guru99WebDriverImpl;
import com.examples.config.GlobalDataStore;
public class Guru99HomePage {

	Guru99WebDriverImpl driver;
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By stepsToGenerateAccess=By.xpath("//h4[@class='barone']");
	By linkTest = By.linkText("here");
	By loginButtonTest = By.xpath("//input[@name='btnLogin']");
	By resetButtonTest = By.xpath("//input[@name='btnReset']");

	GlobalDataStore gds=new GlobalDataStore();
	WebDriver driverInstance;

	public void setWebDriver(Guru99WebDriverImpl webDriver) {

		this.driver = webDriver;
		// Log.info("END: Set TMXDriver Method");

	}

	public String getHomePageDashboardUserName() {

		Reporter.log("Guru99HomePage getHomePageDashboard " + driver.FindElement(homePageUserName).getText(), true);
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		// driver.FindElement(homePageUserName).click();
		return driver.FindElement(homePageUserName).getText();
	}
	
	public String getStepsToGenerateAccess() {

		Reporter.log("Guru99HomePage getStepsToGenerateAccess " + driver.FindElement(stepsToGenerateAccess).getText(), true);
		// System.out.println(" The Text
		// "+driver.FindElement(homePageUserName).getText());
		// driver.FindElement(homePageUserName).click();
		return driver.FindElement(stepsToGenerateAccess).getText();
	}
	public boolean getLink() {

		Reporter.log("Guru99HomePage getlink is pressent : " + driver.FindElement(linkTest).isEnabled(), true);

		return driver.FindElement(linkTest).isEnabled();
	}
	
	public boolean getLoginButton() {

		Reporter.log("Guru99HomePage getlink is pressent : " + driver.FindElement(loginButtonTest).isEnabled(), true);

		return driver.FindElement(loginButtonTest).isEnabled();
	}
	
	public boolean getResetButton() {

		Reporter.log("Guru99HomePage getlink is pressent : " + driver.FindElement(resetButtonTest).isEnabled(), true);

		return driver.FindElement(resetButtonTest).isEnabled();
	}


}
