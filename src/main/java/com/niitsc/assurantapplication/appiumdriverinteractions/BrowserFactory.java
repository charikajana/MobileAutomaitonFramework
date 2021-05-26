package com.niitsc.assurantapplication.appiumdriverinteractions;

import java.io.File;
import java.io.IOException;

import java.util.Set;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.niitsc.assurantapplication.appconstants.AppConstants;
import com.niitsc.assurantapplication.fileOperations.FileOperations;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BrowserFactory {
	public static WebDriver driver;
	public static String browserVersion="";
	/**
	 * This method will open browser according to user argument passed
	 * @param browser
	 * @return it will return the driver
	 */
	public static WebDriver getBrowser() {
		String browser=	FileOperations.DerivergetProperty(AppConstants.BROWSER);
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			driver = firefoxBrowser();
			break;
		case "CHROME":
			driver =chromeBrowser();
			break;
		case "IE":
			driver =iEbrowser();
			break;
		default:
			driver =firefoxBrowser();
			break;

		}
		return driver;

	}

	public static WebDriver iEbrowser()
	{
		DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		cap.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\IEDriverServer.exe");		
		driver=new InternetExplorerDriver();
		String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		if (uAgent.contains("MSIE") && uAgent.contains("Windows")) {
			browserVersion = uAgent.substring(uAgent.indexOf("MSIE")+5, uAgent.indexOf("Windows")-2);
		} else if (uAgent.contains("Trident/7.0")) {
			browserVersion = "11.0";
		} else {
			browserVersion = "0.0";
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver chromeBrowser() {
		ChromeOptions chromeOptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver firefoxBrowser() {
		

		driver = new FirefoxDriver(firefoxDesiredCapabilities());		
		Capabilities capb=((RemoteWebDriver)driver).getCapabilities();
		browserVersion=(String)capb.getCapability("browserVersion");
		driver.manage().window().maximize();
		return driver;
	}
		
	public static String getDownloadLocation() throws IOException
	{
		String dir = null;
		File directory = new File (".");	
		dir = directory.getCanonicalPath();    
		String DownloadPath= dir+"\\Downloaded Files";
		return DownloadPath;
	}

	/*
	 * @SuppressWarnings({ "unchecked", "unused", "rawtypes" }) public static void
	 * SwitchtonewwindowinIOS() { try { Set<String> contexts =
	 * ((AppiumDriver<WebElement>) driver).getContextHandles(); String myContext =
	 * ""; if (contexts.size() > 2) { for (String context : contexts) { if
	 * (!context.equalsIgnoreCase("NATIVE_APP")) { ((AppiumDriver)
	 * driver).context(context); if
	 * (!driver.getTitle().trim().equalsIgnoreCase("Golf Store")) {
	 * System.out.println("My title" + driver.getTitle()); Thread.sleep(2000); }
	 * else myContext = context; } } Thread.sleep(5000); } } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
		public static DesiredCapabilities firefoxDesiredCapabilities(){
			DesiredCapabilities cap=DesiredCapabilities.firefox();		
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\geckodriver.exe");			
			try{				
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("dom.popup_maximum", 20);
				profile.setPreference("browser.popups.showPopupBlocker",false);
				profile.setPreference("privacy.popups.showBrowserMessage",false);
				profile.setPreference("dom.popup_allowed_events","change click dblclick mouseup notificationclick reset submit touchend"); 
				profile.setPreference("app.update.enabled", false);       
				profile.setPreference("browser.download.folderList",2);
				profile.setPreference("browser.download.manager.showWhenStarting",false);
				profile.setPreference("browser.download.dir",getDownloadLocation());
				profile.setPreference("browser.download.useDownloadDir", true);
				profile.setPreference("browser.helperApps.neverAsk.openFile","text/csv, application/pdf, application/x-msexcel,application/excel,application/x-excel,application/excel,application/x-excel,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/excel");
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf, text/csv, application/x-pdf, application/acrobat, applications/vnd.pdf, text/pdf, text/x-pdf, application/octet-stream");
				profile.setPreference("browser.helperApps.alwaysAsk.force", false);
				profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				profile.setPreference("browser.download.manager.focusWhenStarting", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				profile.setPreference("browser.download.manager.showAlertOnComplete", false);
				profile.setPreference("browser.download.manager.closeWhenDone", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				profile.setPreference("dom.popup_allowed_events",true);
				profile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
				profile.setPreference("pdfjs.disabled", true);
				profile.setAcceptUntrustedCertificates(true);
				profile.setAssumeUntrustedCertificateIssuer(false);
				cap.setCapability(FirefoxDriver.PROFILE, profile);
				return cap;
			}catch(Exception e){
		}
			return cap;
	}
}