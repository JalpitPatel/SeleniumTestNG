package com.selenium.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class setupBrowser {
	public static WebDriver driver=null;
	public WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.navigate().to(Constants.URL);
		
		return driver;
	}
	
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
}
