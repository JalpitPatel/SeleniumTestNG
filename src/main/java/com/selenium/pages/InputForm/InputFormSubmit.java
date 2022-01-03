package com.selenium.pages.InputForm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.selenium.utils.Constants;
import com.selenium.utils.ExcelDataProvider;
import com.selenium.utils.setupBrowser;

public class InputFormSubmit extends setupBrowser {

	static ExcelDataProvider excelUtils = new ExcelDataProvider();
	static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;

	public InputFormSubmit() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[contains(@class,'dropdown')]//child::li/a[contains(text(),'Input Form Submit')]")
	WebElement inputFormLink;

	@FindBy(name = "first_name")
	WebElement txtFirstname;

	@FindBy(name = "last_name")
	WebElement txtLastname;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "phone")
	WebElement txtPhone;

	@FindBy(name = "address")
	WebElement txtAddress;

	@FindBy(name = "city")
	WebElement txtCity;

	@FindBy(name = "state")
	WebElement drpState;

	@FindBy(name = "zip")
	WebElement txtZip;

	@FindBy(name = "website")
	WebElement txtWebsite;

	@FindBy(name = "comment")
	WebElement txtProjectDesc;

	@FindBy(xpath = "//button[text()='Send ']")
	WebElement btnSend;

	public void navigateToInputForm() {
		inputFormLink.click();
	}

	public void fillRegsiterFields() throws Exception {
		excelUtils.setExcelFile(excelFilePath, "RegData");
		int noOfRow = excelUtils.getNoOfRowInSheet();
		Select select = new Select(drpState);
		for (int i = 1; i <= noOfRow; i++) {
			txtFirstname.clear();
			txtFirstname.sendKeys(excelUtils.getCellData(i, 0));
			txtLastname.clear();
			txtLastname.sendKeys(excelUtils.getCellData(i, 1));
			txtEmail.clear();
			txtEmail.sendKeys(excelUtils.getCellData(i, 2));
			txtPhone.clear();
			txtPhone.sendKeys(excelUtils.getCellData(i, 3));
			txtAddress.clear();
			txtAddress.sendKeys(excelUtils.getCellData(i, 4));
			txtCity.clear();
			txtCity.sendKeys(excelUtils.getCellData(i, 5));
			select.selectByVisibleText(excelUtils.getCellData(i, 6));
			txtZip.clear();
			txtZip.sendKeys(excelUtils.getCellData(i, 7));
			txtWebsite.clear();
			txtWebsite.sendKeys(excelUtils.getCellData(i, 8));

			WebElement HostingYes = driver.findElement(By.xpath("//input[@value= '" + excelUtils.getCellData(i, 9) + "' and @name='hosting']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", HostingYes);

			txtProjectDesc.clear();
			txtProjectDesc.sendKeys(excelUtils.getCellData(i, 10));

			btnSend.click();
			
			boolean successMsg = true;
			if(successMsg) {
				excelUtils.setCellValue(i,11, "Pass",excelFilePath);
			}
			else {
				excelUtils.setCellValue(i,11, "Fail",excelFilePath);
			}

		}
	}

}
