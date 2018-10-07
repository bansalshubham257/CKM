package com.framework.pageAction;


import com.framework.pageElement.LoginPage;
import com.framework.test.TestBase;

public class LoginPageAction {
	
	public void setUsername(String username) {
	
		TestBase.getElement(new LoginPage().tfUsername).sendKeys(username);;
	}
	
	public void setPassword(String password) {
		TestBase.getElement(new LoginPage().tfPassword).sendKeys(password);
	}
	
	public void clickNext() {
		TestBase.getElement(new LoginPage().btnNext).click();
	}

}
