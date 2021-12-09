package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactTest extends TestBase {
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	
	Logger log=Logger.getLogger(ContactTest.class);
	
	
	LoginPage logdriver;
	HomePage homedriver;
	TestUtil utildriver;
	ContactPage contactdriver;
		// for git test
	public ContactTest() {
		super();
	}

	@BeforeMethod()
	public void Setup() throws IOException, InterruptedException {
		initialization();
		log.info("*********************************************************************************8launching the URL");

		logdriver = new LoginPage();
		logdriver.login(prop.getProperty("username"), prop.getProperty("password"));
		
		log.info("Login succesfull");

		homedriver = new HomePage();

		utildriver = new TestUtil();

		WebElement ele11 = homedriver.clicOnContactLinl();

		utildriver.mouseOver(ele11);

		homedriver.clickOnAdCOntactButton().click();
		utildriver.highLighterMethod(driver, ele11);
		Thread.sleep(3000);

		contactdriver = new ContactPage();

	}

	@Test(priority = 1)
	public void contactLableverify() {
		System.out.println("pass");
		log.info("*******************First Test success**************************");
		

		Assert.assertTrue(contactdriver.ContactLable());
		

	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = TestUtil.getTestData("sheet1");
		return data;
	}

	@Test(priority = 2, dataProvider = "getData")
	public void createContatc(String fn, String ln, String company) throws InterruptedException {
		contactdriver.createNewContact(fn, ln, company);
		Thread.sleep(2000);

	}

	@AfterMethod()
	public void teardown() {
		log.warn("****************************************this is just warming message");
		driver.quit();
	}
}
