package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.basetest.BaseTest;

public class ContactsPage extends BaseTest {
	
	//Object repositories
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	private WebElement contactsLabel;
	
	
	//initialize the constructor
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Action methods
	public boolean validateContactsPageLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String contactName){
		driver.findElement(By.xpath("//a[text()='"+contactName+"']//parent::td[@class='datalistrow']"
				+ "//preceeding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	
	
}
