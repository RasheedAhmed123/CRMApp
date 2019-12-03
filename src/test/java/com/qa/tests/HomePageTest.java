package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.basetest.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewContactPage;
import com.qa.utils.TestUtils;

public class HomePageTest extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	NewContactPage newcontactpage;
	TestUtils testutils;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testutils = new TestUtils();
		loginpage = new LoginPage();
		newcontactpage = new NewContactPage();
		homepage= loginpage.validateToLoginToCRMApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2, enabled= false)
	public void verifyTheLoggedInUserNameTest(){
		testutils.switchToFrame();
		boolean loggedInUser= homepage.verifyCorrectUserName();
		Assert.assertTrue(loggedInUser, "Logged in username is not displayed");
	}
	
	@Test(priority=1, enabled= false)
	public void verifyHomePageTitleTest(){
		String homePageTitle= homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.", "HomePage title not matched");
	}
	
	@Test(priority=3, enabled= false)
	public void verifyContactsLinkTest(){
		testutils.switchToFrame();
		homepage.clickOnContactsLink();
	}
	
	@Test(priority=4, enabled= false)
	public void verifyTasksLinkTest(){
		testutils.switchToFrame();
		homepage.clickOnTasksLink();
	}
	
	@Test(priority=5, enabled= false)
	public void verifyDealsLinkTest(){
		testutils.switchToFrame();
		homepage.clickOnDealsLink();
	}
	
	@Test(priority= 6)
	public void verifyToClickOnNewContactLinkTest() {
		testutils.switchToFrame();
		newcontactpage= homepage.clickOnNewContactLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
