package com.automation.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.DriverInstance;

public class VerifyProductInCart extends DriverInstance {
	WebElement	view_product_1,
				product_1_detail,
				product_1_quantity,
				product_1_cart,
				view_cart_popup,
				view_quantity_1,
				close_product_1,
				cart_table;
	@BeforeMethod
	public void openPage() {
		driver.get(prop.getProperty("base_url"));
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void TC_VerifyProductInCart()throws Exception {
		view_product_1 = driver.findElement(By.xpath(prop.getProperty("view_product_1")));
		view_product_1.click();
		Thread.sleep(5000);
		
		//verify product detail
		product_1_detail = driver.findElement(By.xpath(prop.getProperty("product_1_detail")));
		assertTrue(product_1_detail.isDisplayed());
		
		//increase quanntity: 4
		product_1_quantity = driver.findElement(By.xpath(prop.getProperty("product_1_quantity")));
		product_1_quantity.clear();
		product_1_quantity.sendKeys("4");
		
		//Add to cart
		product_1_cart = driver.findElement(By.xpath(prop.getProperty("product_1_cart")));
		product_1_cart.click();
		Thread.sleep(2000);
		
		//view cart
		view_cart_popup = driver.findElement(By.xpath(prop.getProperty("view_cart_popup")));
		view_cart_popup.click();
		Thread.sleep(2000);
		
		//verify the quantity
		view_quantity_1 = driver.findElement(By.xpath(prop.getProperty("view_quantity_1")));
		assertEquals(view_quantity_1.getText(), "4");
		
		//remove product
		close_product_1 = driver.findElement(By.xpath(prop.getProperty("close_product_1")));
		close_product_1.click();
		Thread.sleep(2000);
		
		//Verify that product is removed from the cart
		cart_table = driver.findElement(By.xpath(prop.getProperty("cart_table")));
		assertEquals(false, cart_table.isDisplayed());
	}
}
