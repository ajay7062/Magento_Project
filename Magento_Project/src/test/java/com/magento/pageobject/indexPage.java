package com.magento.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	WebDriver ldriver;

	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Create an Account") 
	WebElement CreateAccount;
	
	@FindBy(linkText = "Sign In") 
	WebElement SignIn;
	
	public void clickOnCreateAccount() {
		CreateAccount.click();
	}
	
	public void clickOnSignIns() {
		SignIn.click();
	}
	
}
