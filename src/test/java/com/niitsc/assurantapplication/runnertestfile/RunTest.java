package com.niitsc.assurantapplication.runnertestfile;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
		//dryRun=true,
		features={
				"classpath:features"
				},
		
		plugin = {
				"pretty",
				"json:reports/results/mainrun/jsonreport/runtest-automation.json"
			},
		glue = {
				"com.niitsc.assurantapplication.stepdefs",
			},
		tags = "@TestcaseID22375")
public class RunTest extends AbstractTestNGCucumberTests{
	

}
