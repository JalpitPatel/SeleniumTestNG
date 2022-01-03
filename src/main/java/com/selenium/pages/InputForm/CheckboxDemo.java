package com.selenium.pages.InputForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.utils.setupBrowser;

public class CheckboxDemo extends setupBrowser{
	
	public CheckboxDemo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[contains(@class,'dropdown')]//child::li/a[contains(text(),'Checkbox Demo')]")
	WebElement checkboxDemoLink;
	
	@FindBy(xpath="//*[@id='isAgeSelected']")
	WebElement singleCheckbox;
	
	@FindBy(id="txtAge")
	WebElement getCheckedMsg;
	
	@FindBy(id="check1")
	WebElement checkAll;
	
	@FindBy(id="isChkd")
	WebElement getAllCheck;
	
	@FindBy(xpath= "//div[@id='navbar-brand-centered']/ul/li/a[contains(text(),'Input Forms')]")
	WebElement inputFormMenu;
	
	public void clickInputFormMenu() {
		inputFormMenu.click();
	}
	
	public void navigateToCheckboxDemo() {
		checkboxDemoLink.click();
	}
	
	public void checkSingleCheckbox(String expectedResult) {
		singleCheckbox.click();
		String ActualMsg = getCheckedMsg.getText();
		System.out.println(ActualMsg);
		Assert.assertEquals(expectedResult, ActualMsg);
			
	}
	
	public void checkAllCheckboxes() {
		checkAll.click();
		String expectedValue = getAllCheck.getAttribute("value");
		Assert.assertEquals(expectedValue, "false"); 
	}
	
}
