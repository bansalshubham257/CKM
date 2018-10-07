package com.framework.pageAction;

import com.framework.pageElement.AssetViewPage;
import com.framework.test.TestBase;

public class AssetViewPageAction {
	
	public void clickEyeBtn() {
	
		TestBase.getElement(new AssetViewPage().btnEye).click();
	}
	
	public void clickInfoBtn() {
		
		TestBase.getElement(new AssetViewPage().btnInfo).click();
	}
	
	public void clickVersionBtn() {
		
		TestBase.getElement(new AssetViewPage().btnVersions).click();
	}
	
	public void clickCommentsBtn() {
		
		TestBase.getElement(new AssetViewPage().btnComments).click();
	}
	
	public void clickDistributeBtn() {
		
		TestBase.getElement(new AssetViewPage().btnDistribute).click();
	}
	
	public void clickOnSendApprovalBtn() {
		
		TestBase.getElement(new AssetViewPage().btnSendForApproval).click();
	}

	
	public void clickOnWithoutApprovalBtn() {
		
		TestBase.getElement(new AssetViewPage().btnWithoutApproval).click();
	}

	
	public void clickExitBtn() {
		
		TestBase.getElement(new AssetViewPage().btnExit).click();
	}
	
	public String getApprovalStatus() {
			
			return TestBase.getElement(new AssetViewPage().approvalProgress).getText();
	}

}
