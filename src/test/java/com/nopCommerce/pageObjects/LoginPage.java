package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	WebElement txtEmail;
	
	@FindBy(id="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement btnLogin;
	
	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	
	public void setUserName(String username)
	{
		txtEmail.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	

}
