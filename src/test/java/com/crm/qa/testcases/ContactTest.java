package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactTest extends TestBase {
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

		logdriver = new LoginPage();
		logdriver.login(prop.getProperty("username"), prop.getProperty("password"));

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
		driver.quit();
	}
}
