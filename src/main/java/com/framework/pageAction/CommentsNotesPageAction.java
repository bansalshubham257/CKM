package com.framework.pageAction;

import com.framework.functions.RobotClass;
import com.framework.pageElement.CommentsNotesPage;
import com.framework.test.TestBase;

public class CommentsNotesPageAction {
	
	public void setComments(String comments) {
		
		TestBase.getElement(new CommentsNotesPage().tfComments).sendKeys(comments);
		new RobotClass().clickEnter();

	}
	
	public void clickOnuploadComments() {
		
		TestBase.getElement(new CommentsNotesPage().btnUploadComments).click();
		
	}

	public void clickOnCloseComments() {
		
		TestBase.getElement(new CommentsNotesPage().btnCloseComments).click();
		
	}
	
	public void clickOnAssetCloseComments() {
		
		TestBase.getElement(new CommentsNotesPage().btnAssetCommentsClose).click();
		
	}

	

	public void clickOnVersionCheckBox() {
		
		TestBase.getElement(new CommentsNotesPage().chkBoxCommentsVersion).click();
		
	}

	public void setNotes(String notes) {
		
		TestBase.getElement(new CommentsNotesPage().tfNotes).sendKeys(notes);
		
	}

	
}
