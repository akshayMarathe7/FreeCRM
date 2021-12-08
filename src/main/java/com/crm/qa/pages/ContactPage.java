package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	@FindBy(xpath = "//div[text()='Create New Contact']")
	WebElement contactLable;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//div[@name='company']/input")
	WebElement company;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement savbtn;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean ContactLable() {
		return contactLable.isDisplayed();
	}

	public void createNewContact(String fname, String lname, String cpmny) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(cpmny);

		savbtn.click();
	}

}
