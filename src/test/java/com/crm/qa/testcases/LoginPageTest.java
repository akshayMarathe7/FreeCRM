package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage logindriver;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod()
	public void setup() throws IOException {
		initialization();

		logindriver = new LoginPage();

	}

	@Test(priority = 1)
	public void validatePageTitle() {
		String TitleofPage = logindriver.validateTitleOfHomePage();
		Assert.assertEquals(TitleofPage, "#1 Free CRM customer relationship management software cloud");

	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {

		logindriver.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod()
	public void teardown() {

		driver.quit();
	}


}
