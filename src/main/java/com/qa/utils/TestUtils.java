package com.qa.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.basetest.BaseTest;

public class TestUtils extends BaseTest{
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	
}
