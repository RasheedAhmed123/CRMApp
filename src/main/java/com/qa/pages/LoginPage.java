package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basetest.BaseTest;

public class LoginPage extends BaseTest{
	
	
	//Object Repositories or Page Factory
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(linkText="Selenium Jobs")
	private WebElement seleniumJobsLink;
	
	//Initialize the Obj Repo
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateSeleniumJobsLink(){
		return seleniumJobsLink.isDisplayed();
	}
	
	public HomePage validateToLoginToCRMApplication(String un, String pwd){
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.submit();
		return new HomePage();
	}
	
}
