package com.qa.basetest;

public interface Constants {
	
	String chromeBrowserKey= "webdriver.chrome.driver";
	String chromeBrowserValue= "./drivers/chromedriver.exe";
	String firefoxBrowserKey = "webdriver.gecko.driver";
	String firefoxBrowserValue = "./drivers/geckodriver.exe";
	static final long implicitWaitValue = 10;
	static final long pageLoadTimeOutValue = 15;
}
