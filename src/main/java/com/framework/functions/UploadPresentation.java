package com.framework.functions;

import org.testng.Assert;

import com.framework.pageAction.UploadPresentationPageAction;
import com.framework.pageElement.UploadPresentationPage;

public class UploadPresentation {

	public static void loadPresentation(String presentationName) {
		
		UploadPresentationPageAction uploadPresentationPageAction = new UploadPresentationPageAction();
		uploadPresentationPageAction.clickBrowse();

		Wait.sleep(2000);
		
		RobotClass robotClass = new RobotClass();
		
		robotClass.copyText(presentationName);
		robotClass.pasteText();
	    robotClass.clickEnter();
        
	    Wait.sleep(2000);
	    
        String actualValue = uploadPresentationPageAction.getUploadingStatus();
        Wait.waitInvisibilityOfElementWithText(new UploadPresentationPage().uploadingProgress, 1500, actualValue);
        actualValue = uploadPresentationPageAction.getUploadingStatus();
      
        if(!actualValue.toLowerCase().equals("complete")) {
        	Assert.fail();
        }
        
        Wait.sleep(2000);
        
        uploadPresentationPageAction.clickClose();
        
        Wait.sleep(2000);
		
	}

	
}
