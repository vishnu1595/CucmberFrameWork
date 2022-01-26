package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	// 1. By Locators:
	private By user_name= By.name("user_name");
	private By user_password = By.name("user_password");
	private By login = By.id("submitButton");
	private By readLicense = By.linkText("Read License");
	// 2. Constructor of the page class :
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	// 3. Page actions: features(behavior) of the page the form of methods:
	
	public String  getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isreadLicenseLinkExist() {
		return driver.findElement(readLicense).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(user_name).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(user_password).sendKeys(pwd);
	}
	
	public void ClickOnLogin() {
		driver.findElement(login).click();
	}
	
	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with user name : "+un +" and pwd : "+pwd);
		driver.findElement(user_name).sendKeys(un);
		driver.findElement(user_password).sendKeys(pwd);
		driver.findElement(login).click();
		return new HomePage(driver);
		
	}
}
