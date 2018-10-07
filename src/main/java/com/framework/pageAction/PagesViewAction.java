package com.framework.pageAction;

import com.framework.functions.Wait;
import com.framework.pageElement.PagesView;
import com.framework.test.TestBase;

public class PagesViewAction {

	public void clickOnGroup() {
		
		TestBase.getElement(new PagesView().btnGroup).click();
	}
	
	public void clickOnChoosePages() {
		
		TestBase.getElement(new PagesView().btnChoosePage).click();
		
	}

	public void editSlide(String slideName) {
		
		TestBase.getElement(new PagesView().btnEditSlide.replaceAll("SlideName", slideName)).click();
		
	}

	public void setSlideTitle(String title) {
		
		TestBase.getElement(new PagesView().tfEditSlideTitle).clear();
		TestBase.getElement(new PagesView().tfEditSlideTitle).sendKeys(title);
		
	}
	
	public void setSlideDescription(String description) {
		
		TestBase.getElement(new PagesView().tfEditSlideDescription).sendKeys(description);
		
	}

	public void clickOnKeyMessageDropDwn() {
		
		TestBase.getElement(new PagesView().btnClickOnKeyMessage).click();
		
	}

	public void selectKeyMessage(String[] keyMessages) {
		
		Wait.sleep(3000);
		
		for(String keyName : keyMessages) {
			TestBase.getElement(new PagesView().chkBoxSelectKeyMessage.replaceAll("keyMessageName", keyName)).click();
		}
	}
	
	public void saveBtnOnKeyMessage() {
		TestBase.getElement(new PagesView().btnSave).click();
	}

	public void closeBtnOnKeyMessage() {
		TestBase.getElement(new PagesView().btnClose).click();
	}

	public void deleteBtnOnKeyMessage() {
		TestBase.getElement(new PagesView().btnDelete).click();
	}


	
	
	
}
