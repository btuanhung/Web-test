package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.ScreenShots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	protected WebDriver driver;
	protected PropertiesFileUtils prop = new PropertiesFileUtils();
	protected WebDriverWait wait;
	protected Actions act;
	@BeforeClass
	public void Init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterMethod
	public void takeScreenShot(ITestResult result)throws Exception {
		if(ITestResult.FAILURE == result.getStatus()) {
			String email = (String) result.getParameters()[0];
			int index = email.indexOf("@");
			String accountName = email.substring(0, index);
			ScreenShots.takeScreeShot(driver, accountName);
			ScreenShots.attachScreenShot(accountName);
		}
	}
	@AfterClass
	public void terminate() {
		driver.quit();
	}
}
