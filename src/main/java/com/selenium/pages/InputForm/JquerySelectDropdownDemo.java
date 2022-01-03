package com.selenium.pages.InputForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selenium.utils.setupBrowser;

public class JquerySelectDropdownDemo extends setupBrowser {

	public JquerySelectDropdownDemo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/a[text() ='JQuery Select dropdown']")
	WebElement jQueryDropdownLink;

	@FindBy(xpath = "//select[@id='country']/following-sibling::span")
	WebElement drpCountry;

	@FindBy(xpath = "//span[contains(@class,'select2-dropdown')]/span/Input")
	WebElement txtCountry;

	public WebElement xpathSelectCountry(String var) {
		WebElement selectCountry = driver.findElement(By.xpath("//li[text()='" + var + "']"));
		return selectCountry;
	}
	
	@FindBy(xpath="//label[contains(text(),'Select State')]/following-sibling::select")
	WebElement multiDrpState;
	
	
	
	public void navigateToJqueryDropdownDemo() {
		jQueryDropdownLink.click();
	}
	
	public void dropDownSearchBox(String country) {
		drpCountry.click();
		txtCountry.sendKeys(country);
		String searchCountry = txtCountry.getAttribute("value");
		xpathSelectCountry(searchCountry).click();
	}
	
	public void multiSelectDropdown() {
		Select select = new Select(multiDrpState);
		//List<WebElement> lst = select.getOptions();
		//for(WebElement options: lst)
           // System.out.println(options.getText());
			for(int i=0; i<=4; i++) {
				select.selectByIndex(i);
			}
	}
	
	
}
