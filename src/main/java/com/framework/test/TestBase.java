package com.framework.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.framework.configure.Configuration;

public class TestBase {

	public static WebDriver driver;
 
	public TestBase() {
		
		String browser = Configuration.getProperties("browser").toLowerCase();
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Files//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Files//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("internet explorer") || browser.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
	}
	
	public static void launchHomePage() {
		
		driver.get(Configuration.getProperties("url"));
		driver.manage().window().maximize();

	}

	public static WebElement getElement(String locator) {
		
		WebElement element = null;
		
		String locatorName = locator.split(":")[0].toLowerCase();
		//String locatorValue = locator.split(":")[1];
		String locatorValue = locator.substring(locator.indexOf(":")+1);
		
		if(locatorName.equals("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		else if(locatorName.equals("name")) {
			element = driver.findElement(By.name(locatorValue));
		}
		else if(locatorName.equals("classname")) {
			element = driver.findElement(By.className(locatorValue));
		}
		else if(locatorName.equals("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		else if(locatorName.equals("linktext")) {
			element = driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorName.equals("partiallinktext")) {
			element = driver.findElement(By.partialLinkText(locatorValue));
		}
		
		return element;
	}
	
	
	public static List<WebElement> getElements(String locator) {
		
		List<WebElement> element = null;
		
		String locatorName = locator.split(":")[0].toLowerCase();
		//String locatorValue = locator.split(":")[1];
		String locatorValue = locator.substring(locator.indexOf(":")+1);
		
		if(locatorName.equals("id")) {
			element = driver.findElements(By.id(locatorValue));
		}
		else if(locatorName.equals("name")) {
			element = driver.findElements(By.name(locatorValue));
		}
		else if(locatorName.equals("classname")) {
			element = driver.findElements(By.className(locatorValue));
		}
		else if(locatorName.equals("xpath")) {
			element = driver.findElements(By.xpath(locatorValue));
		}
		else if(locatorName.equals("linktext")) {
			element = driver.findElements(By.linkText(locatorValue));
		}
		else if(locatorName.equals("partiallinktext")) {
			element = driver.findElements(By.partialLinkText(locatorValue));
		}
		
		return element;
	}

	
	public static By getLocator(String locator) {
	
		By locatorlv = null;
		String locatorName = locator.split(":")[0].toLowerCase();
		String locatorValue = locator.split(":")[1];

		
		if(locatorName.equals("id")) {
			locatorlv = By.id(locatorValue);
		}
		else if(locatorName.equals("name")) {
			locatorlv = By.name(locatorValue);
		}
		else if(locatorName.equals("classname")) {
			locatorlv = By.className(locatorValue);
		}
		else if(locatorName.equals("xpath")) {
			locatorlv = By.xpath(locatorValue);
		}
		else if(locatorName.equals("linktext")) {
			locatorlv = By.linkText(locatorValue);
		}
		else if(locatorName.equals("partiallinktext")) {
			locatorlv = By.partialLinkText(locatorValue);
		}
		
		return locatorlv;
	}
	
	
	public static void launchURL(String url) {
		driver.navigate().to(url);
	}

	public static void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
	}

	
}
