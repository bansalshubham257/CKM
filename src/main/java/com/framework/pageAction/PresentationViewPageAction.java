package com.framework.pageAction;

import com.framework.pageElement.PagesView;
import com.framework.pageElement.PresentationViewPage;
import com.framework.test.TestBase;

public class PresentationViewPageAction {
	
	public void clickEyeBtn() {
	
		TestBase.getElement(new PresentationViewPage().btnEye).click();
	}
	
	public void clickInfoBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnInfo).click();
	}
	
	public void clickViewPortBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnViewPort).click();
	}
	
	public void clickEditBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnEdit).click();
	}
	
	public void clickVersionBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnVersions).click();
	}
	
	public void clickTrackingBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnTracking).click();
	}
	
	public void clickSaveBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnSave).click();
	}
	
	public void clickAssetsBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnAssets).click();
	}
	
	public void clickCommentsBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnComments).click();
	}
	
	public void clickNotesBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnNotes).click();
	}
	
	public void clickDistributeBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnDistribute).click();
	}
	
	public void clickOnSendApprovalBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnSendForApproval).click();
	}

	
	public void clickOnWithoutApprovalBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnWithoutApproval).click();
	}

	
	
	public void clickExitBtn() {
		
		TestBase.getElement(new PresentationViewPage().btnExit).click();
	}
	
	public boolean isHtmlPages() {
		try {
			return TestBase.getElement(new PagesView().btnGroup).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}

	public String getApprovalStatus() {
			
			return TestBase.getElement(new PresentationViewPage().approvalProgress).getText();
	}
	
	public boolean isSaveBtnDisabled() {
		
		return TestBase.getElement(new PresentationViewPage().saveBtnEnableOrDisable).getAttribute("class").contains("disable");

	}


}
