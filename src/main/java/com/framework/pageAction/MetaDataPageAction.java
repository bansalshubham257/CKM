package com.framework.pageAction;

import org.openqa.selenium.support.ui.Select;

import com.framework.functions.Wait;
import com.framework.pageElement.MetaDataPage;
import com.framework.test.TestBase;

public class MetaDataPageAction {

	public void setTitle(String title) {
		
		TestBase.getElement(new MetaDataPage().tfTitle).sendKeys(title);
	}
	
	public void setDescription(String description) {
		
		TestBase.getElement(new MetaDataPage().tfDescription).sendKeys(description);
	}
	
	public void selectProduct(String productName) {
		
		Select select = new Select(TestBase.getElement(new MetaDataPage().ddProduct));
		select.selectByVisibleText(productName);
		
	}
	
	public void clickYesButton() {
		
		TestBase.getElement(new MetaDataPage().btnYes).click();
		
	}
	
	public void selectLanguage(String language) {
		
		Select select = new Select(TestBase.getElement(new MetaDataPage().ddLanguage));
		select.selectByVisibleText(language);
		
	}
	
	public void clickOnPositionGroup() {
		
		TestBase.getElement(new MetaDataPage().ddPositionGroup).click();
		
	}
	
	public void selectPositionGroup(String[] positionGroups) {
		
		Wait.sleep(3000);
		
		for(String positionName : positionGroups) {
			TestBase.getElement(new MetaDataPage().chkBoxSelectPosition.replaceAll("positionName", positionName)).click();
		}
	}
	


	
}
