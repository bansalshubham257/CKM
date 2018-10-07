package com.framework.functions;

import com.framework.pageAction.PagesViewAction;

public class KeyMessage {
	
	public void setKeyMessages(String title, String description, String slideName, String[] keyMessages) {
		
		PagesViewAction pagesViewAction = new PagesViewAction();
		pagesViewAction.editSlide(slideName);
		pagesViewAction.setSlideTitle(title);
		pagesViewAction.setSlideDescription(description);
		pagesViewAction.clickOnKeyMessageDropDwn();
		pagesViewAction.selectKeyMessage(keyMessages);
		pagesViewAction.saveBtnOnKeyMessage();
		
	}

}
