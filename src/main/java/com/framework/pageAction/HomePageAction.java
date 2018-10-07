package com.framework.pageAction;


import com.framework.pageElement.HomePage;
import com.framework.test.TestBase;

public class HomePageAction {
	
	public void clickImport() {
	
		TestBase.getElement(new HomePage().ddImport).click();
	}
	
	public void clickUploadPresentationButton() {
		
		TestBase.getElement(new HomePage().btnImportPresentation).click();
	}
	
	public void clickUploadAssetButton() {
		
		TestBase.getElement(new HomePage().btnImportAsset).click();
	}
	
	public void clickUploadDocumentButton() {
		
		TestBase.getElement(new HomePage().btnImportDocument).click();
	}

	
	/////////////////////////////////////////////////////////////
	
	public void clickUserProfile() {
		
		TestBase.getElement(new HomePage().ddUserProfile).click();
	}
	
	public void clickUserSettingButton() {
		
		TestBase.getElement(new HomePage().btnUserSetting).click();
	}
	
	public void clickUserLogoutButton() {
		
		TestBase.getElement(new HomePage().BtnUserLogout).click();
	}
	
	//////////////////////////////////////////////////////////////////
	
	
	public void clickPresentationsLink() {
		
		TestBase.getElement(new HomePage().lnkPresentations).click();
	}
	
	public void clickAssetsLink() {
		
		TestBase.getElement(new HomePage().lnkAssets).click();
	}
	
	public void clickDocumentLink() {
		
		TestBase.getElement(new HomePage().lnkDocuments).click();
	}

	
	public void clickReviewsLink() {
		
		TestBase.getElement(new HomePage().lnkReviews).click();
	}
	
	public void clickEmailsLink() {
		
		TestBase.getElement(new HomePage().lnkEmails).click();
	}
	public void clickSurveysLink() {
		
		TestBase.getElement(new HomePage().lnkSurveys).click();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public void clickFilterDropdown() {
		
		TestBase.getElement(new HomePage().ddFilter).click();
	}
	public void filterPresentationByName() {
		
		TestBase.getElement(new HomePage().btnFilterPresentationByName).click();
	}
	
	public void filterPresentationByAuthor() {
		
		TestBase.getElement(new HomePage().btnFilterPresentationByAuthor).click();
	}
	public void searchPresentation(String presentationName) {
		
		TestBase.getElement(new HomePage().btnSearchPresentation).sendKeys(presentationName);
	}

	//////////////////////////////////////////////////////////////////////
	
	public void clickModifyDropdown() {
		
		TestBase.getElement(new HomePage().ddModify).click();
	}
	
	public void modifyPresentationByName() {
		
		TestBase.getElement(new HomePage().btnModifyPresentationByName).click();
		
	}
	public void modifyPresentationByLastUpdated() {
		
		TestBase.getElement(new HomePage().btnModifyPresentationByLast).click();
	}

	
	///////////////////////////Shortcuts/////////////////////////////////////
	
	public void clickShortcutDropDown(String fileName) {
		
		TestBase.getElement(new HomePage().ddShortcutMenu.replaceAll("filename", fileName)).click();
	}
	
	public void clickDeleteShortcut(String fileName) {
		
		TestBase.getElement(new HomePage().btnDeleteShortcut.replaceAll("filename", fileName)).click();
		TestBase.getElement(new HomePage().btnDeleteConfirm).click();
		
	}
	
	
	public void clickRenameShortcut(String fileName) {
		
		TestBase.getElement(new HomePage().btnRenameShortcut.replaceAll("filename", fileName)).click();
	}

	public void setRenameTitle(String title) {
		
		TestBase.getElement(new HomePage().tfRenameTitle).clear();
		TestBase.getElement(new HomePage().tfRenameTitle).sendKeys(title);;
	}

	public void clickRenameSave() {
		
		TestBase.getElement(new HomePage().btnRenameSave).click();
	}

	
	public void clickDuplicateShortcut(String fileName) {
		
		TestBase.getElement(new HomePage().btnDuplicateShortcut.replaceAll("filename", fileName)).click();
	}
	
	public void setDuplicateTitle(String title) {
		TestBase.getElement(new HomePage().tfDuplicateTitle).clear();
		TestBase.getElement(new HomePage().tfDuplicateTitle).sendKeys(title);;
	}

	public void clickDuplicateSave() {
		
		TestBase.getElement(new HomePage().btnDuplicateSave).click();
	}

	
	public void clickShareShortcut(String fileName) {
		
		TestBase.getElement(new HomePage().btnShareShortcut.replaceAll("filename", fileName)).click();
	}

	public void viewPresentation(String name) {
		
		TestBase.getElement(new HomePage().viewPresentation+name+"')]").click();
	}

	public int countPresentationHomePage() {
		
		return TestBase.getElements(new HomePage().presentationDiv).size();
	}

	
}
