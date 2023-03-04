package com.automation.testcase;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;

public class SearchProduct extends DriverInstance {
	WebElement image, productName;
	@BeforeMethod
	public void openPage() {
		driver.get(prop.getProperty("products_link"));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	@Test
	public void TC_SP()throws Exception {
		Thread.sleep(1000);
		
		driver.findElement(By.id(prop.getProperty("inputSearch"))).sendKeys(prop.getProperty("nameToSearch"));
		driver.findElement(By.id(prop.getProperty("btnSearch"))).click();
		
		Thread.sleep(1000);
		
		//check product name
		productName = driver.findElement(By.xpath(prop.getProperty("productName")));
		assertEquals(productName.getText(), prop.getProperty("nameToSearch"));
		 
		//check product image
		image = driver.findElement(By.xpath(prop.getProperty("image")));
		assertTrue(image.isDisplayed());
	}
}
