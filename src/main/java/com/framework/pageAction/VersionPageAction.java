package com.framework.pageAction;

import com.framework.pageElement.VersionPage;
import com.framework.test.TestBase;

public class VersionPageAction {
	
	public int totalVersionCount() {
	
		return TestBase.getElements(new VersionPage().versionsList).size();
	}
	
	public void clickStatusDetailsBtn() {
		
		TestBase.getElement(new VersionPage().btnStatusDetails).click();
	}
	
	public void clickNewVersionBtn() {
		
		TestBase.getElement(new VersionPage().btnNewVersion).click();
	}

}
