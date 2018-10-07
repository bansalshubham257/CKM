package com.framework.pageElement;

public class PagesView {

	public String btnGroup = "xpath:/html/body/app-root/app-editor/div/app-tabs/div/app-tab[5]/div/div[2]/div/div/button";
	public String btnChoosePage = "xpath:/html/body/app-root/app-editor/div/app-tabs/div/app-tab[5]/div/div[4]/button";
	public String btnEditSlide = "xpath://a[contains(text(),'SlideName')]/following-sibling::a";
	
	public String tfEditSlideTitle = "id:tab-title";
	public String tfEditSlideDescription = "xpath:/html/body/ngb-modal-window/div/div/app-tab-modal/div[2]/div[3]/div/textarea";
	public String btnClickOnKeyMessage = "xpath:/html/body/ngb-modal-window/div/div/app-tab-modal/div[2]/div[2]/div/app-multi-select/div/div[1]/div/div[2]";
	
	public String chkBoxSelectKeyMessage = "xpath://input[@type='checkbox']/following-sibling::label[text()='keyMessageName']";
	
	public String btnSave = "xpath:/html/body/ngb-modal-window/div/div/app-tab-modal/div[3]/button[2]";
	public String btnClose = "xpath:/html/body/ngb-modal-window/div/div/app-tab-modal/div[3]/button[3]";
	public String btnDelete = "xpath:/html/body/ngb-modal-window/div/div/app-tab-modal/div[3]/button[1]";
	
}
