package com.qa.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest implements Constants{
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public BaseTest() {
		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//qa//config//config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	public void initialization(){
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty(chromeBrowserKey, chromeBrowserValue);
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty(firefoxBrowserKey, firefoxBrowserValue);
			driver = new FirefoxDriver();
		}else{
			System.out.println("Browser name not defined OR Check the browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWaitValue, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOutValue, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
}
