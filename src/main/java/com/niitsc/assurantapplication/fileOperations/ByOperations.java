package com.niitsc.assurantapplication.fileOperations;

import org.openqa.selenium.By;

public class ByOperations {
	public static By getByargument(String property){
		By by=null;
		String byValue=FileOperations.DerivergetProperty(property).split(";")[1];
		String byType=FileOperations.DerivergetProperty(property).split(";")[0];
		switch(byType.toUpperCase()){
		case "ID":
			by=	By.id(byValue);
			break;
		case "XPATH":
			by=By.xpath(byValue);
			break;
		case "LINKTEXT":
			by=By.linkText(byValue);
			break;
		case "PARTIALLINKTEXT":
			by=By.partialLinkText(byValue);
			break;
		case "CLASSNAME":
			by=By.className(byValue);
			break;
		case "NAME":
			by=By.name(byValue);
			break;
		}
		return by;
		
	}
}
