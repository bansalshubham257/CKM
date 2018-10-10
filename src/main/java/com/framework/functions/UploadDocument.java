package com.framework.functions;

import org.testng.Assert;

import com.framework.pageAction.UploadPresentationPageAction;
import com.framework.pageElement.UploadPresentationPage;

public class UploadDocument {

	public static void loadAsset(String presentationName) {
		
		Wait.waitElementToBeClickable(new UploadPresentationPage().btnBrowse, 10);
		
		UploadPresentationPageAction uploadPresentationPageAction = new UploadPresentationPageAction();
		uploadPresentationPageAction.clickBrowse();

		Wait.sleep(2000);
		
		RobotClass robotClass = new RobotClass();
		
		robotClass.copyText(presentationName);
		robotClass.pasteText();
	    robotClass.clickEnter();
        
	    Wait.sleep(1000);
	    
	    String actualValue = uploadPresentationPageAction.getUploadingStatus();
        
        if(!actualValue.toLowerCase().contains("complete")) {
        
        	Wait.waitInvisibilityOfElementWithText(new UploadPresentationPage().uploadingProgress, 1500, actualValue);
        	actualValue = uploadPresentationPageAction.getUploadingStatus();
        	
        }
        
        if(!actualValue.toLowerCase().contains("complete")) {
        	Assert.fail();
        }
        
        Wait.sleep(2000);
        
        uploadPresentationPageAction.clickClose();
        
        Wait.sleep(2000);
		
	}

	
}
