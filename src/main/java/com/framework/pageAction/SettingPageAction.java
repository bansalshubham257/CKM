package com.framework.pageAction;

import com.framework.pageElement.SettingPage;
import com.framework.test.TestBase;

public class SettingPageAction {

	public String getRoles() {
		
		return TestBase.getElement(new SettingPage().labelRoles).getText();
		
	}
	
	public void selectSinglePage() {
		
		TestBase.getElement(new SettingPage().spaRadioBtn).click();
	}

	public void selctMultiPage() {
		
		TestBase.getElement(new SettingPage().multiPageRadioBtn).click();
	}

	/*public boolean isMultiPageSelected() {
		
		return TestBase.getElement(new SettingPage().multiPageRadio).isSelected();
		
	}

	public boolean isSinglePageSelected() {
		
		return TestBase.getElement(new SettingPage().spaRadio).isSelected();
	}*/

	
	public void clickCloseBtn() {
		
		TestBase.getElement(new SettingPage().btnClose).click();
	}
	
	public void clickSaveBtn() {
		
		TestBase.getElement(new SettingPage().btnSave).click();
	}
	
	public String getTitle() {
		
		return TestBase.getElement(new SettingPage().settingTitle).getText();
	}
	
	
	
	
	
}
