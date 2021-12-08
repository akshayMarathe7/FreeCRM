package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	// Page Objects
	@FindBy(xpath="//span[contains(text(),'akshay marathe')]")
	WebElement userLable;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement searchfield;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[3]/button/i")
	WebElement AddcontacButton;

	//Inilializing page objet
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String titleOfHomePage()
	{
		String titleHomePage=driver.getTitle();
		return titleHomePage;
	//	return driver.getTitle();
	}
	public Boolean verifyingUserLable()
	{
		Boolean flag=userLable.isDisplayed();
		return flag;
	}
	public Boolean verifySearchField()
	{
		boolean flag=searchfield.isDisplayed();
		return flag;
	}
	
	public WebElement clicOnContactLinl()
	{
		WebElement ele=ContactsLink;
		return ele;
	}
	public WebElement clickOnAdCOntactButton()
	{
	return	AddcontacButton;
	}
	
	
}
