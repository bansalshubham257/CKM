package com.framework.functions;

import com.framework.pageAction.MetaDataPageAction;

public class MetaData {
	
	public void setInfo(String title, String description, String product, String language, String[] positionGroup) {
		
		MetaDataPageAction metaDataPageAction = new MetaDataPageAction();
		
		metaDataPageAction.setTitle(title);
		metaDataPageAction.setDescription(description);
		metaDataPageAction.selectLanguage(language);
		metaDataPageAction.selectProduct(product);
		metaDataPageAction.clickYesButton();
		metaDataPageAction.clickOnPositionGroup();
		metaDataPageAction.selectPositionGroup(positionGroup);
		
		
	}

	public void setInfo(String title, String description, String product, String language) {
		
		MetaDataPageAction metaDataPageAction = new MetaDataPageAction();
		
		metaDataPageAction.setTitle(title);
		metaDataPageAction.setDescription(description);
		metaDataPageAction.selectLanguage(language);
		metaDataPageAction.selectProduct(product);
		
	}

	
	public void setInfo(String title, String description, String language) {
		
		MetaDataPageAction metaDataPageAction = new MetaDataPageAction();
		
		metaDataPageAction.setTitle(title);
		metaDataPageAction.setDescription(description);
		metaDataPageAction.selectLanguage(language);
		
	}
	
	public void setInfo(String product) {
		
		MetaDataPageAction metaDataPageAction = new MetaDataPageAction();
		
		metaDataPageAction.selectProduct(product);
		metaDataPageAction.clickYesButton();
		
	}

	
	public void setInfo(String[] positionGroup) {
		
		MetaDataPageAction metaDataPageAction = new MetaDataPageAction();
		metaDataPageAction.clickOnPositionGroup();
		metaDataPageAction.selectPositionGroup(positionGroup);
		
	}


}
