package com.qa.PomPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.sun.tools.javac.util.Assert;

public class HomePage extends TestBase {

	@FindBy(xpath="/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	public WebElement UserNameLabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	public WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	public WebElement NewcontactLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	public WebElement DealsLink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	public WebElement TaskLink;
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	public String VerifyCurrentUserName() {
	 return UserNameLabel.getText();
	}
	public String verifyHomePageTitle() {
		 return driver.getTitle();
		
	}
	public ContactPage ClickOnContactsLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage ClickOnDealsLink() {
		DealsLink.click();
		return  new DealsPage();
	}
	
	public TaskPage ClickOnTaskLink() {
		TaskLink.click();
		return  new TaskPage();

	}
	public void ClickOnNewContactLink()  {
		//driver.navigate().back();
		Actions a=new Actions(driver);
		a.moveToElement(contactsLink).build().perform();
		NewcontactLink.click();
	}
	}
