package com.magento.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {

	WebDriver ldriver;

	public myAccountPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']") 
	WebElement AccInfo;
	

	//identify webelements
	@FindBy(xpath = "//span[@class='base']")
	WebElement userName;
	
	@FindBy(linkText="My Account")
	WebElement myAccont;

	@FindBy(linkText="Sign Out")
	WebElement signOut;
	
	public void clickOnAccInfo() 
	{
		AccInfo.click();
	}
	
	public String getUserName()
	{
		String text = userName.getText();

		return text;
	}
	
	public void clickOnmyAccontBtns()
	{
		myAccont.click();
	}

	public void clickOnsignOut()
	{
		signOut.click();
	}
	
}
