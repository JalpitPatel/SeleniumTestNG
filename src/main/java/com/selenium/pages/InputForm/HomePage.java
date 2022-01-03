package com.selenium.pages.InputForm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.setupBrowser;

public class HomePage extends setupBrowser {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='at-cv-lightbox-close']")
	WebElement closePopup;
	
	@FindBy(xpath= "//div[@id='navbar-brand-centered']/ul/li/a[contains(text(),'Input Forms')]")
	WebElement inputFormMenu;

	
	public void closeAdPopUp() {
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		closePopup.click();
	}
	
	public void clickInputFormMenu() {
		inputFormMenu.click();
	}
}
