package com.selenium.pages.InputForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.selenium.utils.setupBrowser;

public class RadioButtonDemo extends setupBrowser{

	public RadioButtonDemo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//ul[contains(@class,'dropdown')]//child::li/a[contains(text(),'Radio Buttons Demo')]")
	WebElement radioButtonDemoLink;
	
	@FindBy(xpath= "//input[@name='optradio' and @value='Male']")
	WebElement radioMale1;
	
	@FindBy(id="buttoncheck")
	WebElement btnGetCheckedVal;
	

	public WebElement xpathlblCheckedRadio(String gender) {
		WebElement lblCheckedRadio = driver.findElement(By.xpath("//p[contains(text(),'Radio button '"+gender+"' is checked')]"));
		return lblCheckedRadio;
	}
	
	@FindBy(xpath= "//input[@name='gender' and @value='Male']")
	WebElement radioMale2;
	
	@FindBy(xpath="//input[@name='ageGroup' and @value='15 - 50']")
	WebElement ageGroup;
	
	@FindBy(xpath="//button[contains(text(),'Get values')]")
	WebElement btnGetValues;
	
	@FindBy(xpath="//p[@class='groupradiobutton']")
	WebElement lblGroupRadioChecked;
	
	public void navigateTORadioButtonDemo() {
		radioButtonDemoLink.click();
	}
	
	public void checkRadioButton() {
		if(radioMale1.isEnabled()) {
			radioMale1.click();
		}
		btnGetCheckedVal.click();
		/*
		 * String checkedRadioVal = radioMale1.getAttribute("value");
		 * System.out.println("gender1: "+checkedRadioVal); String ActualMsg =
		 * xpathlblCheckedRadio(checkedRadioVal).getAttribute("value");
		 * System.out.println("gender: "+ActualMsg);
		 * Assert.assertEquals("Radio button 'Male' is checked", ActualMsg);
		 */			
	}
	
	public void checkGroupRadioButton() {
		if(radioMale2.isEnabled()) {
			radioMale2.click();
		}
		if(ageGroup.isDisplayed()) {
			ageGroup.click();
		}
		btnGetValues.click();
		System.out.println(lblGroupRadioChecked.getText());
		
	}
}
