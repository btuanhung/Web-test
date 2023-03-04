package com.automation.testcase;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;

public class AddProductInCart extends DriverInstance {
	String 	product_name_1,
			product_price_1,
			product_name_2,
			product_price_2;

	WebElement 	cart_product_1,
				view_name_1,
				view_price_1,
				view_quantity_1,
				view_total_1,
				continue_shopping,
				cart_product_2,
				view_name_2,
				view_price_2,
				view_quantity_2,
				view_total_2,
				view_cart_popup;
	@BeforeMethod
	public void openPage() {
		driver.get(prop.getProperty("products_link"));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	@Test
	public void AddProduct() throws Exception {
		product_name_1 = driver.findElement(By.xpath(prop.getProperty("product_name_1"))).getText();
		product_price_1 = driver.findElement(By.xpath(prop.getProperty("product_price_1"))).getText();
		cart_product_1 = driver.findElement(By.xpath(prop.getProperty("cart_product_1")));
		cart_product_1.click();
		Thread.sleep(2000);
		
		continue_shopping =	driver.findElement(By.xpath(prop.getProperty("continue_shopping")));
		continue_shopping.click();
		Thread.sleep(2000);
		
		product_name_2 = driver.findElement(By.xpath(prop.getProperty("product_name_2"))).getText();
		product_price_2 = driver.findElement(By.xpath(prop.getProperty("product_price_2"))).getText();
		cart_product_2 = driver.findElement(By.xpath(prop.getProperty("cart_product_2")));
		cart_product_2.click();
		Thread.sleep(2000);
		
		view_cart_popup = 
				driver.findElement(By.xpath(prop.getProperty("view_cart_popup")));
		view_cart_popup.click();
		Thread.sleep(2000);
		
		//verify product 1
		view_name_1 = driver.findElement(By.xpath(prop.getProperty("view_name_1")));
		assertTrue(view_name_1.isDisplayed());
		assertEquals(view_name_1.getText(), product_name_1);
		
		view_price_1 = driver.findElement(By.xpath(prop.getProperty("view_price_1")));
		assertTrue(view_price_1.isDisplayed());
		assertEquals(view_price_1.getText(), product_price_1);
		
		view_quantity_1 = driver.findElement(By.xpath(prop.getProperty("view_quantity_1")));
		assertTrue(view_quantity_1.isDisplayed());
		
		view_total_1 = driver.findElement(By.xpath(prop.getProperty("view_total_1")));
		assertTrue(view_total_1.isDisplayed());
		
		//verify product 2
		view_name_2 = driver.findElement(By.xpath(prop.getProperty("view_name_2")));
		assertTrue(view_name_2.isDisplayed());
		assertEquals(view_name_2.getText(), product_name_2);
		
		view_price_2 = driver.findElement(By.xpath(prop.getProperty("view_price_2")));
		assertTrue(view_price_2.isDisplayed());
		assertEquals(view_price_2.getText(), product_price_2);
		
		view_quantity_2 = driver.findElement(By.xpath(prop.getProperty("view_quantity_2")));
		assertTrue(view_quantity_2.isDisplayed());
		
		view_total_2 = driver.findElement(By.xpath(prop.getProperty("view_total_2")));
		assertTrue(view_total_2.isDisplayed());
	}
}
