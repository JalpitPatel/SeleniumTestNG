package com.selenium.test;

import org.testng.annotations.Test;

import com.selenium.pages.InputForm.CheckboxDemo;
import com.selenium.pages.InputForm.HomePage;
import com.selenium.pages.InputForm.InputFormSubmit;
import com.selenium.pages.InputForm.JquerySelectDropdownDemo;
import com.selenium.pages.InputForm.RadioButtonDemo;
import com.selenium.pages.InputForm.SimpleFormDemo;
import com.selenium.utils.TestListner;
import com.selenium.utils.setupBrowser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(TestListner.class)
public class InputFormTest extends setupBrowser {
	
  HomePage home;
  SimpleFormDemo form;
  CheckboxDemo check;
  RadioButtonDemo radio;
  JquerySelectDropdownDemo drp;
  InputFormSubmit input;
  
  public InputFormTest() {
	  super();
  }
  
 
@BeforeSuite(alwaysRun = true)
  public void setUp() {
	  launchBrowser("Chrome");
	  home = new HomePage();	  
	  home.closeAdPopUp();
  }

  @Parameters({"msg"})
  @Test(priority = 1, groups = { "Functionality" })
  public void TC001_testSimpleInputForm(String param) {
	  form = new SimpleFormDemo();
	  home.clickInputFormMenu();
	  form.navigateToSimpleForm();
	  form.enterMessage(param);
	  form.clickOnShowMessage();
	  form.getMessage();
	  form.enterValueInOperands(50,20);
	  form.clickOnGetTotal();
	  form.getTotal();
  }
  
  @Parameters({"result"})
  @Test(priority = 2, groups = {"Web Controls Test"})
  public void TC002_testCheckboxDemo(String result) {
  	  check = new CheckboxDemo();
  	  home.clickInputFormMenu();
  	  check.navigateToCheckboxDemo();
  	  check.checkSingleCheckbox(result);
  	  check.checkAllCheckboxes();
  }
  
  @Test(priority=3, groups = {"Web Controls Test"})
  public void TC003_testRadioButtonDemo() {
	  radio = new RadioButtonDemo();
	  home.clickInputFormMenu();
	  radio.navigateTORadioButtonDemo();
	  radio.checkRadioButton();
	  radio.checkGroupRadioButton();
	  
  }
  
  @Parameters({"country"})
  @Test(priority=4, groups = {"Web Controls Test"})
  public void TC004_testJquerySelectDropdown(String country) {
	  drp = new JquerySelectDropdownDemo();
	  home.clickInputFormMenu();
	  drp.navigateToJqueryDropdownDemo();
	  drp.dropDownSearchBox(country);
	  drp.multiSelectDropdown();
  }
  
  @Test(priority=5, groups = {"Functionality"})
  public void TC005_testInputFormSubmit() throws Exception {
	  input = new InputFormSubmit();
	  home.clickInputFormMenu();
	  input.navigateToInputForm();
	  input.fillRegsiterFields();
  }
  
  @AfterSuite(alwaysRun = true)
  public void afterTest() {
	  tearDown();
  }

  

}
