package com.framework.pageAction;

import org.openqa.selenium.By;

import com.framework.pageElement.UploadPresentationPage;
import com.framework.test.TestBase;

public class UploadPresentationPageAction {
	
	public void clickBrowse() {
	
		TestBase.getElement(new UploadPresentationPage().btnBrowse).click();
	}
	
	public void clickClose() {
		
		TestBase.getElement(new UploadPresentationPage().btnClose).click();
	}
	
	public void clickCross() {
		
		TestBase.getElement(new UploadPresentationPage().btnCross).click();
	}
	
	public String getUploadingStatus() {
		
		return TestBase.getElement(new UploadPresentationPage().uploadingProgress).getText();
	}

	public By getUploadingStatusElement() {
		// TODO Auto-generated method stub
		return TestBase.getLocator(new UploadPresentationPage().uploadingProgress);
	}

	public String getMultipleUploadingStatus() {
		// TODO Auto-generated method stub
		return TestBase.getElement(new UploadPresentationPage().multipleUploadingProgress).getText();
	}

	public By getMultipleUploadingStatusElement() {
		// TODO Auto-generated method stub
		return TestBase.getLocator(new UploadPresentationPage().multipleUploadingProgress);
	}

	
}
