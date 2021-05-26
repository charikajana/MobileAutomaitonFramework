package com.niitsc.assurantapplication.stepdefs.chatspage;

import com.niitsc.assurantapplication.allpageobjects.AllpageObjects;
import com.niitsc.assurantapplication.appconstants.AppConstants;
import com.niitsc.assurantapplication.fileOperations.FileOperations;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;



public class Loginpagestepdefs {
	public AllpageObjects allpageobjects;
	protected Scenario scenario;
	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
		allpageobjects=new AllpageObjects();
	}
	@Given("^launch browser and open application$")
	public void launch_browser_and_open_application() throws Throwable {
		allpageobjects.webdriverintractions.get(FileOperations.DerivergetProperty(AppConstants.URL));
		allpageobjects.webdriverintractions.waitForPageLoad();
	}

	@Given("^Enter username \"([^\"]*)\" and Enter password \"([^\"]*)\"$")
	public void enter_username_and_Enter_password(String emailid, String password) throws Throwable {
		allpageobjects.webdriverintractions.sendKeys("Loginpage.Email", emailid);
		//scenario.write("Enter Username"+emailid);
		allpageobjects.webdriverintractions.click("Loginpage.signIn");
		allpageobjects.webdriverintractions.waitForPageLoad();
		allpageobjects.webdriverintractions.sendKeys("Loginpage.Passwd", password);
		//scenario.write("Enter password"+password);
		allpageobjects.webdriverintractions.clickUsingJSExecutor("Loginpage.signIn");
		allpageobjects.webdriverintractions.waitForPageLoad();
		
	}
	
	

}
