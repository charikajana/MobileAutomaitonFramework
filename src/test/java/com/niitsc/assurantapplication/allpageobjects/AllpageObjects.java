package com.niitsc.assurantapplication.allpageobjects;

import com.niitsc.assurantapplication.appiumdriverinteractions.WebDriverInteractions;
import com.niitsc.assurantapplication.reusable.homepage.LoginToApplication;

public class AllpageObjects {
	public WebDriverInteractions webdriverintractions;
	public LoginToApplication logintoapplication;
	
	
	
	
	public AllpageObjects() {
		webdriverintractions=new WebDriverInteractions();
		logintoapplication=new LoginToApplication(webdriverintractions);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
