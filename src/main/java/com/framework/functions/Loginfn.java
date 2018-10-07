package com.framework.functions;

import com.framework.pageAction.LoginPageAction;
import com.framework.pageElement.LoginPage;

public class Loginfn {

	public void getLogin(String username, String password) {
		
		LoginPageAction loginPage = new LoginPageAction();
		loginPage.setUsername(username);
		loginPage.clickNext();
		Wait.waitPresenceOfElementLocated(new LoginPage().tfPassword, 10);
		loginPage.setPassword(password);
		Wait.waitElementToBeClickable(new LoginPage().btnNext, 10);
		loginPage.clickNext();
		
	}

	
}
