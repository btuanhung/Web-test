package com.automation.testcase;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.ScreenShots;

public class LoginTest extends DriverInstance {
	@BeforeMethod
	public void openPage() {
		driver.get(prop.getProperty("base_url"));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	@Test(dataProvider = "Excel")
	public void LoginTest(String email, String password) throws Exception {
		LoginPage log = new LoginPage(driver);
		log.login(email, password);
		WebElement signout = driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
		assertEquals("Logout", signout.getText());
		signout.click();
		Thread.sleep(1000);
	}
	@DataProvider(name = "Excel")
	public Object [][] testDataGenerator() throws Exception{
		FileInputStream fis = new FileInputStream("./TestData/Login_data_test.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		Sheet loginSheet = wb.getSheet("Login");
		int numberOfData = loginSheet.getPhysicalNumberOfRows();
		Object [][] testData = new Object[numberOfData][2];
		for(int i = 0; i < numberOfData; i++) {
			Row rw = loginSheet.getRow(i);
			Cell email = rw.getCell(0);
			Cell password = rw.getCell(1);
			testData [i][0] = email.getStringCellValue();
			testData [i][1] = password.getStringCellValue();
		}
		return testData;
	}/*
	@AfterMethod
	public void takeScreenShot(ITestResult result)throws Exception {
		if(ITestResult.FAILURE == result.getStatus()) {
			String email = (String) result.getParameters()[0];
			int index = email.indexOf("@");
			String accountName = email.substring(0, index);
			ScreenShots.takeScreeShot(driver, accountName);
			ScreenShots.attachScreenShot(accountName);
		}
	}*/
}
