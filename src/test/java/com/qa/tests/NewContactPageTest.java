package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class NewContactPageTest extends BaseTest {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	
	public NewContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage = new LoginPage();
		homepage= loginpage.validateToLoginToCRMApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void validateNewContactPageTest(){
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
