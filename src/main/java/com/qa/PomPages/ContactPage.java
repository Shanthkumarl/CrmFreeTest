package com.qa.PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactPage extends TestBase{
@FindBy(xpath="//td[contains(text(),'Contacts')]")
public WebElement ContactLabel;

@FindBy(xpath="//input[@name='contact_id']")
public WebElement checkbox;

@FindBy(id="first_name")
public WebElement Firstname;

@FindBy(id="surname")
public WebElement Lastname;

@FindBy(name="client_lookup")
public WebElement Companyname;

@FindBy(xpath="//input[@type='submit']")
public WebElement Savebtn;

public ContactPage() {
	PageFactory.initElements(driver, this);
}

public boolean verifycontactLabel() {
	return ContactLabel.isDisplayed();
}

public void selectCheckbox() {
	checkbox.click();
}

public void creatNewContact(String tagname,String Fname,String Lname,String Cname){
	Select s=new Select(driver.findElement(By.name("title")));
	s.selectByVisibleText(tagname);
	Firstname.sendKeys(Fname);
	Lastname.sendKeys(Lname);
	Companyname.sendKeys(Cname);
    Savebtn.click();
}



}
