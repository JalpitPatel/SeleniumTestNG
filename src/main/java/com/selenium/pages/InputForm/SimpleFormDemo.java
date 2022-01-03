package com.selenium.pages.InputForm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.utils.setupBrowser;

public class SimpleFormDemo extends setupBrowser{
	

	public SimpleFormDemo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//ul[contains(@class,'dropdown')]//child::li/a[contains(text(),'Simple Form Demo')]")
	WebElement simpleFormDemoLink;
	
	@FindBy(xpath="//input[@id='user-message']")
	WebElement singleInputFieldtxt;
	
	@FindBy(xpath="//button[contains(text(),'Show Message')]")
	WebElement singleInputFieldBtnShowMsg;
	
	@FindBy(xpath="//label[contains(text(),'Your Message')]/following-sibling::span[@id='display']")
	WebElement singleInputFieldLblEnteredMsg;
	
	@FindBy(id="sum1")
	WebElement twoInputFieldstxtOperand_A;
	
	@FindBy(id="sum2")
	WebElement twoInputFieldstxtOperand_B;
	
	@FindBy(xpath="//div[@class='form-group']//following-sibling::button[contains(text(),'Get Total')]")
	WebElement twoInputFieldsBtnTotal;
	
	@FindBy(id="displayvalue")
	WebElement twoInputFieldsLblTotal;
	
	public void navigateToSimpleForm() {
		simpleFormDemoLink.click();
	}
	
	public void enterMessage(String msg) {
		singleInputFieldtxt.clear();
		singleInputFieldtxt.sendKeys(msg);
	}
	
	public void clickOnShowMessage() {
		if(singleInputFieldBtnShowMsg.isEnabled()) {
			singleInputFieldBtnShowMsg.click();
		}		
	}	
	public String getMessage() {		
		return singleInputFieldLblEnteredMsg.getText();
	}
	
	public void enterValueInOperands(int a, int b) {
		twoInputFieldstxtOperand_A.clear();
		twoInputFieldstxtOperand_A.sendKeys(String.valueOf(a));
		twoInputFieldstxtOperand_B.clear();
		twoInputFieldstxtOperand_B.sendKeys(String.valueOf(b));
	}
	
	public void clickOnGetTotal() {
		if(twoInputFieldsBtnTotal.isEnabled()) {
			twoInputFieldsBtnTotal.click();
		}
	}
	
	public String getTotal() {		
		return twoInputFieldsLblTotal.getText();
	}
}
