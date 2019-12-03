package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.basetest.BaseTest;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class ContactsPageTest extends BaseTest{
	
	LoginPage loginpage;
	ContactsPage contactspage;
	HomePage homepage;
	TestUtils testutils;
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage= new LoginPage();
		contactspage = new ContactsPage();
		homepage = new HomePage();
		testutils = new TestUtils();
		homepage= loginpage.validateToLoginToCRMApplication(prop.getProperty("username"), prop.getProperty("password"));
		testutils.switchToFrame();
		homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactPageLabelTest(){
		boolean contactspagelabel= contactspage.validateContactsPageLabel();
		Assert.assertTrue(contactspagelabel, "Contacts page label is missing from Contacts page");
	}
	
	@Test(priority=2)
	public void verifyToSelectContactsTest(){
		contactspage.selectContactsByName("Daniel Bryan");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
