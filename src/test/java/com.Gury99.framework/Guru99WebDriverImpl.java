package com.guru99.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.examples.config.GlobalDataStore;

public class Guru99WebDriverImpl implements Guru99WebDriver { 
	

	  

	/**
	 * Initialize the Web Driver.
	 */
	WebDriver driver;

	@SuppressWarnings("deprecation")
	public void init(String Browser) {

		// Log.info("START:init Method for Getting the Proper Drivers for
		// Browser");
		System.out.println("The webDriver Init Method");

		String UserDir = System.getProperty("user.dir");
		String OS = OSDetector();
		// Log.info("The OS Detetcted " + OS);

		if (Browser.equalsIgnoreCase("chrome") && (OS.equals("Mac"))) {

			System.setProperty("webdriver.chrome.driver", UserDir + GlobalDataStore.ChromeDriver_MAC);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);

		}

		if (Browser.equals("Chrome") && (OS.equals("Windows"))) {
			// Log.info("Windows chrome Browser ");
			System.setProperty("webdriver.chrome.driver", UserDir + GlobalDataStore.ChromeDriver_WIN);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);

		}

		if (Browser.equals("FireFox") || (Browser.equals("firefox"))) {
			if (OS.equals("Mac")) {
				System.out.println("In Fire fox Driver and Mac " + UserDir + GlobalDataStore.GeckoDriver_MAC);
				System.setProperty("webdriver.gecko.driver", UserDir + GlobalDataStore.GeckoDriver_MAC);
				driver = new FirefoxDriver();
			} else {
				System.out.println("In Fire fox Driver");
				System.setProperty("webdriver.gecko.driver", UserDir + GlobalDataStore.GeckoDriver_WIN);
				driver = new FirefoxDriver();
			}
		}

		if (Browser.equalsIgnoreCase("Edge")) {
			System.out.println("In Edge Driver");
			// String serverPath = "C:\\Program Files (x86)\\Microsoft Web
			// Driver\\MicrosoftWebDriver.exe";
			// System.setProperty("webdriver.edge.driver", UserDir +
			// GlobalDataStore.EDGE_DRIVER);
			driver = new EdgeDriver();
		}

		// Log.info("END:init Method for Getting the Proper Drivers for
		// Browser");
		System.out.println("END:The webDriver Init Method");
	}
	
	@SuppressWarnings("deprecation")
	public void initSauceLabs(String Browser) {

		// Log.info("START:init Method for Getting the Proper Drivers for
		// Browser");
		  String USERNAME = GlobalDataStore.SaucelabUserName;
		  String ACCESS_KEY = GlobalDataStore.SaucelabAccessKey;
		  String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		System.out.println("The webDriver Init Method");
		String[] brArray = Browser.split(",");
		   DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("browserName", brArray[0]);
		    caps.setCapability("platform",  brArray[1]);
		    caps.setCapability("version", brArray[2]);
		    
		    
		    try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		// Log.info("END:init Method for Getting the Proper Drivers for
		// Browser");
		System.out.println("END:The webDriver Init Method");
	}

	public String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}
	}

	public void sendKeys(WebElement element, String name) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

		clickableElement.sendKeys(name);

	}

	public void clickElement(WebElement element) {
		 
		 System.out.println("START: click Element value "+element);
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 try {
		       // System.out.println("The element is " +element.getText());
		        
		        //Wait.someSec(GlobalDataStore.WAIT_TIME);
		  WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		  clickableElement.click();
		  
		 } catch (StaleElementReferenceException e) {

		  System.out.println("Element  " + element.getText() + "Does not exist " + e.getStackTrace());

		 } catch (NoSuchElementException e) {

		  System.out.println("Element  " + element.getText() + "Does not exist " + e.getStackTrace());
		 } catch (Exception e) {
		  
		  System.out.println("Element does not exist " + e.getStackTrace());
		 }
	}
	
	public void acceptPopAlert() {
		 
		 WebDriverWait wait = new WebDriverWait(driver,20 /* timeout in seconds */);

		 if (wait.until(ExpectedConditions.alertIsPresent()) == null)
		  System.out.println("alert was not present");

		 else {

		  System.out.println("alert was present");
		  Alert alert = driver.switchTo().alert();
		  alert.getText();
		  alert.accept();

		 }

		}
	@Override
	public Boolean navigateTo(final String urlString) {

		Boolean mainPageFound = false;

		try {

			System.out.println("The Navigate URL " + urlString);
			String navigateUrl;
			navigateUrl = urlString;

			// PageFactory.initElements(driver, TMXWebDriverImpl.class);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			this.driver.get(navigateUrl);
			String CurrrentUrl = getCurrentUrl();
			// String redirectedUrl = "";
			driver.manage().window().maximize();
			if (CurrrentUrl != null)
				mainPageFound = true;

			// Log.info("END: The navigateTo Method ");

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return mainPageFound;
	}

	public String getCurrentUrl() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public WebDriver getDriverInstance() {

		return driver;
	}

	@Override
	public void quitDriver() {

		if (this.driver != null) {
			this.driver.quit();
			this.driver = null;
			// LOGGER.info("Selenium Web Driver successfully shutdown.");
		}

	}

	@Override
	public WebElement FindElement(By element) {
		System.out.println(" Coming in Find Element");
	//	 WebDriverWait wait = new WebDriverWait(driver,20 /* timeout in seconds */);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//	WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		if (driver.findElement(element).isDisplayed()) {
			System.out.println("The element exists");
			return driver.findElement(element);
		}

		else {
			return null;
		}
	}
	
	
	public List<WebElement> FindElements(By element) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver.findElements(element);
	}

	@Override
	public void closeBrowser() {

		System.out.println("Close Browser");
		this.driver.close();

	}

}
