package com.magento.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.magento.pageobject.accountCreationDetails;
import com.magento.pageobject.indexPage;
import com.magento.pageobject.myAccountPage;
import com.magento.utilities.ReadExcelFile;


public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {

@Test(dataProvider = "LoginDataProvider")
	
	public void verifyCreateAccount(String fname, String lastname, String email, String password, String con_password, String expectedUsername) throws IOException 
	{
		logger.info("***************Verify Create An Account starts*****************"); 

		indexPage pg = new indexPage(driver);
		myAccountPage myAcpg = new myAccountPage(driver);

		pg.clickOnCreateAccount();
		logger.info("Clicked on Create an Account link");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);

		accCreationPg.enterFirstName(fname);
		accCreationPg.enterLastName(lastname);
		accCreationPg.enterEmail(email);
		accCreationPg.enterPassword(password);
		accCreationPg.enterConPassword(con_password);
		accCreationPg.clickOnCreateanAccountBtn();
		logger.info("clicked on Create An AccountBtn button");

		String userName = myAcpg.getUserName();
		Assert.assertEquals(expectedUsername, userName);
		
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
	
	@Test(priority=2, dataProvider = "LoginDataProvider1")
	
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
	{

		logger.info("***************TestCase VerifyLogin starts*****************"); 

		indexPage pg = new indexPage(driver);
		myAccountPage myAcpg = new myAccountPage(driver);
		
		pg.clickOnSignIns();
		logger.info("Clicked on sign in link");

		accountCreationDetails loginDetails = new accountCreationDetails(driver);
		
		logger.info("Sign In Page Open");

		loginDetails.enterLoginEmail(userEmail);
		logger.info("Entered email address");

		loginDetails.enterLoginPassword("userPwd");
		logger.info("Entered password");

		loginDetails.clickOnLoginBtn();
		logger.info("Clicked on sign in link..");
       
        myAcpg.clickOnAccInfo();
        myAcpg.clickOnmyAccontBtns();

		String userName = myAcpg.getUserName();

		if(userName.equals(expectedUsername))
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

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\Magento.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "UserRegistrationData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "UserRegistrationData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"UserRegistrationData", i,j);
			}

		}
		return data;
		
	}
	
	@DataProvider(name = "LoginDataProvider1")
	public String[][] LoginDataProvider1()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\Magento.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
		
	}
		

}
















































