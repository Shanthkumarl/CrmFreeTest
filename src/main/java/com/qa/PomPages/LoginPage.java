package com.qa.PomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page object 
@FindBy (name="username")
public WebElement username;

@FindBy (name="password")
public WebElement password;

@FindBy  (xpath="//input[@type='submit']")
public WebElement loginbtn;

@FindBy (xpath="/html/body/div[2]/div/div[1]/a/img")
public WebElement crmlogo;

@FindBy (xpath="//a[text()='Sign Up']")
public WebElement Singupbtn;
//initailizing the the Page object 
public LoginPage(){
	PageFactory.initElements(driver,this);
}

public String Validatelogintitle() {
	return driver.getTitle();
}

public Boolean validateCrmImage() {
	return crmlogo.isDisplayed();
}

public HomePage ValidateLoginPage(String un, String psw) {
	username.sendKeys(un);
	password.sendKeys(psw);
	loginbtn.click();
	
	return new HomePage();
}
}



