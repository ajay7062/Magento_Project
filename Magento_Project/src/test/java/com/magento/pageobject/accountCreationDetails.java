package com.magento.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	//1. create object of webdriver
	WebDriver ldriver;

	//constructor
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	//Create An Account webelements
	@FindBy(id = "firstname") 
	WebElement Fname;

	@FindBy(id = "lastname") 
	WebElement LName;
	
	@FindBy(id="email_address")
	WebElement userMail;

	@FindBy(id="password")
	WebElement Pass;

	@FindBy(id="password-confirmation")
	WebElement PConfirm;

	@FindBy(xpath="//button[@class='action submit primary']")
	WebElement CreateanAccountBtn;
	 
	//Login webelements
	@FindBy(id = "email") 
	WebElement loginEmail;

	@FindBy(id = "pass") 
	WebElement loginPass;

	@FindBy(xpath="//button[@class='action login primary']")
	WebElement SignInBtn;
	//identify actions to be performed on web elements

	public void enterFirstName(String fname)
	{
		Fname.clear();
		Fname.sendKeys(fname);
	}

	public void enterLastName(String Lname)
	{
		LName.clear();
		LName.sendKeys(Lname);
	}
	public void enterEmail(String UEmail)
	{
		userMail.clear();
		userMail.sendKeys(UEmail);
	}

	public void enterPassword(String pass)
	{
		Pass.clear();
		Pass.sendKeys(pass);
	}

	public void enterConPassword(String Cpwd)
	{
		PConfirm.clear();
		PConfirm.sendKeys(Cpwd);
	}

	
	public void clickOnCreateanAccountBtn()
	{
		CreateanAccountBtn.click();
	}
	
	public void enterLoginEmail(String loginmail)
	{
		loginEmail.clear();
		loginEmail.sendKeys(loginmail);
	}
	
	public void enterLoginPassword(String lopass)
	{
		loginPass.clear();
		loginPass.sendKeys(lopass);
	}
	
	public void clickOnLoginBtn()
	{
		SignInBtn.click();
	}
	
	
	
}
