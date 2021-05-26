package com.niitsc.assurantapplication.reusable.homepage;

import java.io.IOException;

import com.niitsc.assurantapplication.appconstants.AppConstants;
import com.niitsc.assurantapplication.appiumdriverinteractions.WebDriverInteractions;
import com.niitsc.assurantapplication.fileOperations.FileOperations;

import io.cucumber.java.Scenario;



public class LoginToApplication {
	protected WebDriverInteractions webDriverInteractions;
	public LoginToApplication(WebDriverInteractions webDriverInteractions ) {
		this.webDriverInteractions = webDriverInteractions;
	}
	public void loginToApplication(Scenario scenario){
		try {
			webDriverInteractions.get(FileOperations.DerivergetProperty(AppConstants.URL));
			webDriverInteractions.sendKeys("Loginpage.Email",FileOperations.DerivergetProperty(AppConstants.USERNAME));
			webDriverInteractions.click("Loginpage.signIn");
			webDriverInteractions.waitForPageLoad();
			webDriverInteractions.sendKeys("Loginpage.Passwd",FileOperations.DerivergetProperty(AppConstants.PASSWORD));
			webDriverInteractions.waitForPageLoad();
			webDriverInteractions.click("Loginpage.signIn");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
