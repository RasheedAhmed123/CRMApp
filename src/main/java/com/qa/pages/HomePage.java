package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.basetest.BaseTest;

public class HomePage extends BaseTest {
	
	//Object Repository
	@FindBy(linkText="Upgrade your account")
	private WebElement upgradeAccountLink;
	
	@FindBy(xpath="//td[contains(text(),'User')]")
	private WebElement loggedInUserNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement tasksLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	private WebElement newContactLink;
	
	//initialize the constructor
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public boolean validateUpgradeAccountLink(){
		return upgradeAccountLink.isDisplayed();
	}
	
	public boolean verifyCorrectUserName(){
		return loggedInUserNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public NewContactPage clickOnNewContactLink() {
		Actions act= new Actions(driver);
		//act.moveToElement(contactsLink).build().perform();
		act.moveToElement(contactsLink).build().perform();
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(newContactLink));
		newContactLink.click();
		return new NewContactPage();
	}
	
}
