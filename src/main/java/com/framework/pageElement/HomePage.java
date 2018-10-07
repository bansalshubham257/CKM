package com.framework.pageElement;

public class HomePage {

	// DropDowns
	
	public String ddImport = "xpath://a[contains(text(),'Import')]";
	public String btnImportPresentation = "xpath://*[@id='navbarContent']/ul[2]/li[2]/div/a[1]";
	public String btnImportAsset = "xpath://*[@id='navbarContent']/ul[2]/li[2]/div/a[2]";
	public String btnImportDocument = "xpath://*[@id='navbarContent']/ul[2]/li[2]/div/a[3]";
	public String ddUserProfile = "xpath://*[@id='navbarContent']/ul[2]/li[3]/a";
	public String btnUserSetting = "xpath://*[@id='navbarContent']/ul[2]/li[3]/div/a[1]";
	public String BtnUserContentAdmin = "xpath://*[@id='navbarContent']/ul[2]/li[3]/div/a[2]";
	public String BtnUserLogout = "xpath://*[@id='navbarContent']/ul[2]/li[3]/div/a[3]";
	
	//Links
	
	public String lnkPresentations = "xpath://*[@id='navbarContent']/ul[1]/li[1]/a";
	public String lnkAssets = "xpath://*[@id='navbarContent']/ul[1]/li[2]/a";
	public String lnkDocuments = "xpath://*[@id='navbarContent']/ul[1]/li[3]/a";
	public String lnkReviews = "xpath://*[@id='navbarContent']/ul[1]/li[4]/a";
	public String lnkEmails = "xpath://*[@id='navbarContent']/ul[1]/li[5]/a";
	public String lnkSurveys = "xpath://*[@id='navbarContent']/ul[1]/li[6]/a";
	
	//Filter
	
	public String ddFilter = "xpath:/html/body/app-root/app-list/div[1]/app-presentations/div[1]/div[1]/div/div/button";
	public String btnFilterPresentationByName = "xpath:/html/body/app-root/app-list/div[1]/app-presentations/div[1]/div[1]/div/div/div/button[1]";
	public String btnFilterPresentationByAuthor = "xpath:/html/body/app-root/app-list/div[1]/app-presentations/div[1]/div[1]/div/div/div/button[2]";
	public String btnSearchPresentation = "name:search";
	
	
	//Sort
	public String ddModify = "xpath:/html/body/app-root/app-list/div[1]/app-presentations/div[1]/div[2]/div/button";
	public String btnModifyPresentationByName = "xpath:/html/body/app-root/app-list/div[1]/app-presentations/div[1]/div[2]/div/div/button[2]";
	public String btnModifyPresentationByLast = "xpath:/html/body/app-root/app-list/div[1]/app-presentations/div[1]/div[2]/div/div/button[2]";

	// Shortcut Dropdown
	
	public String ddShortcutMenu = "xpath://div[contains(text(),'filename')]//*[@id='dropdown']";
	public String btnDeleteShortcut= "xpath://div[contains(text(),'filename')]/div/div/button[1]";
	
		public String btnDeleteConfirm = "xpath://button[@class='btn btn-danger']";
	
	public String btnRenameShortcut= "xpath://div[contains(text(),'filename')]/div/div/button[2]";
			
		public String tfRenameTitle = "id:title";
		public String btnRenameSave = "xpath://div[@class='modal-content']//div[@class='modal-footer']/button[1]";
	
	public String btnDuplicateShortcut= "xpath://div[contains(text(),'filename')]/div/div/button[3]";
		
		public String tfDuplicateTitle = "id:title";
		public String btnDuplicateSave = "xpath://div[@class='modal-content']//div[@class='modal-footer']/button[1]";

	
	public String btnShareShortcut= "xpath://div[contains(text(),'filename')]/div/div/button[4]";
	
	
	public String viewPresentation = "xpath://div[contains(text(), '";
	
	public String presentationDiv = "xpath://div[@class='row justify-content-between']/div";
}
