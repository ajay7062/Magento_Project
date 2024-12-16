package com.magento.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.pageobject.accountCreationDetails;
import com.magento.pageobject.indexPage;
import com.magento.pageobject.myAccountPage;



public class TC_CreateAnAccount extends BaseClass {


	@Test(priority=0)
	public void verifyCreateAccount() throws InterruptedException
	{
		logger.info("***************Verify Create An Account starts*****************"); 

		indexPage pg = new indexPage(driver);
		myAccountPage myAcpg = new myAccountPage(driver);

		pg.clickOnCreateAccount();
		logger.info("Clicked on Create an Account link");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);

		accCreationPg.enterFirstName("ramsssassa");
		accCreationPg.enterLastName("Ssssasa");
		accCreationPg.enterEmail("rams4444sa@gmail.com");
		accCreationPg.enterPassword("Aj12345678@aj");
		accCreationPg.enterConPassword("Aj12345678@aj");
		accCreationPg.clickOnCreateanAccountBtn();
		logger.info("clicked on Create An AccountBtn button");

		String userName = myAcpg.getUserName();
		Assert.assertEquals("My Account", userName);
		
		logger.info("***************Verify Create An Account ends*****************"); 
	}
	
	@Test(priority=1)
	public void VerifySignOut() throws IOException, InterruptedException 
	{

		logger.info("***************Verify Sign out starts*****************"); 

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.clickOnAccInfo();
		myAcpg.clickOnsignOut();
		logger.info("Sign Out");
		
		logger.info("***************Verify Sign out ends*****************"); 
	}


	@Test(priority=2)
	public void VerifyLogin() throws IOException, InterruptedException 
	{

		logger.info("***************Verify Login starts*****************"); 

		indexPage pg = new indexPage(driver);
		myAccountPage myAcpg = new myAccountPage(driver);
	
		pg.clickOnSignIns();
		logger.info("Clicked on sign in link");

		accountCreationDetails loginDetails = new accountCreationDetails(driver);
		
		logger.info("Sign In Page Open");

		loginDetails.enterLoginEmail("ramsssssaxssa@gmail.com");
		logger.info("Entered email address");

		loginDetails.enterLoginPassword("Aj12345678@aj");
		logger.info("Entered password");

		loginDetails.clickOnLoginBtn();
		logger.info("Clicked on sign in link..");
      
        myAcpg.clickOnAccInfo();
        myAcpg.clickOnmyAccontBtns();

		String userName = myAcpg.getUserName();

		if(userName.equals("My Account"))
		{
			logger.info("VerifyLogin - Passed");
			myAcpg.clickOnAccInfo();
			myAcpg.clickOnsignOut();
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}

		logger.info("***************TestCase Verify Login ends*****************"); 
	}
}
