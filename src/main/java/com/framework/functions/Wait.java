package com.framework.functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.pageElement.PresentationViewPage;
import com.framework.test.TestBase;

public class Wait extends TestBase{
	
	public static void waitElementToBeClickable(String locator,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);

		if(wait.until(ExpectedConditions.elementToBeClickable(TestBase.getLocator(locator)))==null);
	
	}
	
	public static void waitPresenceOfElementLocated(String locator,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);

		if(wait.until(ExpectedConditions.presenceOfElementLocated(TestBase.getLocator(locator)))==null);
	
	}

	public static void waitInvisibilityOfElementWithText(String locator,int time,String actualValue) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		
        wait.until(ExpectedConditions.invisibilityOfElementWithText(TestBase.getLocator(locator), actualValue));
	
	}
	
	public static void waitForSaveButtonDisabled(int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver driver) {
		        if(TestBase.getElement(new PresentationViewPage().saveBtnEnableOrDisable).getAttribute("class").contains("disable")) 
		            return true;
		        else
		            return false;
		    }
		});
	
	}

	
	public static void sleep(long time) {
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
