package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class LoginPageTest extends BaseTest {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage= new LoginPage();
		testutils = new TestUtils();
	}
	
	@Test(priority=3)
	public void loginToCRMApplicationTest() throws InterruptedException{
		homepage= loginpage.validateToLoginToCRMApplication(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		testutils.switchToFrame();
		boolean loggedInUserName= homepage.verifyCorrectUserName();
		Assert.assertTrue(loggedInUserName, "Logged in username is not displayed");
	}
	
	@Test(priority=2)
	public void checkForSeleniumJobsLinkTest(){
		boolean seleniumJobsLink= loginpage.validateSeleniumJobsLink();
		Assert.assertTrue(seleniumJobsLink);
	}
	
	@Test(priority=1)
	public void checkForLoginPageTitleTest(){
		String loginPageTitle= loginpage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
