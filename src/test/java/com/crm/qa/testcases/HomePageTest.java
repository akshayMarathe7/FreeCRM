package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage logindriver;
	HomePage homedriver;
	TestUtil utildriver;

	public HomePageTest() {

		super();
	}

	@BeforeMethod()
	public void setup() throws IOException, InterruptedException {
		initialization();

		logindriver = new LoginPage();
		homedriver = new HomePage();
		logindriver.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyTitle() {
		String hometitle = homedriver.titleOfHomePage();

		Assert.assertEquals(hometitle, "Cogmento CRM1");

	}

	@Test(priority = 2)
	public void verifyLable() {

		Assert.assertTrue(homedriver.verifyingUserLable());
	}

	@Test(priority = 3)
	public void serachfield() {
		Boolean flag1 = homedriver.verifySearchField();
		Assert.assertTrue(flag1);
	}

	@Test(priority = 4)
	public void contactLink() throws InterruptedException {
		utildriver = new TestUtil();
		WebElement ele = homedriver.clicOnContactLinl();
		utildriver.mouseOver(ele);
		homedriver.clicOnContactLinl().click();
		utildriver.highLighterMethod(driver, ele);
		Thread.sleep(4000);
	}

	@AfterMethod()
	public void teardown() {
	//	utildriver.highLighterMethod(driver, ele);
		driver.quit();
	}
}
