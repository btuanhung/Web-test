package com.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href=\"/login\"]")
	WebElement textLogin;
	@FindBy(xpath = "//input[@data-qa=\"login-email\"]")
	WebElement inputEmail;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement inputPassword;
	@FindBy(xpath = "//button[@data-qa=\"login-button\"]")
	WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String email, String password)throws Exception {
		Thread.sleep(2000);
		textLogin.click();
		Thread.sleep(2000);
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
		Thread.sleep(2000);
	}
}
