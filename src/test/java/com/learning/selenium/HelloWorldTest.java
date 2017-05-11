package com.learning.selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HelloWorldTest {
	
	private WebDriver driver;

	@BeforeTest
	public void initalize(){
		//System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox-bin");
		
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		options.addArguments("disable-extensions");
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("--test-type");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");

		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
	}
	
	@Test
	public void googleHelloWorldTest(){
		
		driver.get("http://google.co.in");
	}
	
	@AfterTest
	public void tearDown(){
		
		driver.close();
	}

}
