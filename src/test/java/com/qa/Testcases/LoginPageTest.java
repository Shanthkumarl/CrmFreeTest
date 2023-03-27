package com.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.PomPages.HomePage;
import com.qa.PomPages.LoginPage;
import com.qa.base.TestBase;

public class LoginPageTest extends TestBase {

public  LoginPageTest() {
	super();
}
LoginPage lp;
HomePage Hp; 
@BeforeClass
public void setup() {
	
	initailzation();
	 lp=new LoginPage();

}

@Test(priority = 1)
public void LoginPageTitleTest() {
	String title = lp.Validatelogintitle();
	Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
	
}
@Test(priority = 2)
public void CrmImageTest() {
	Boolean Flag = lp.validateCrmImage();
	Assert.assertTrue(Flag);
}

@Test(priority = 3)
public void ValidateloginTest() {
	Hp=lp.ValidateLoginPage(Prop.getProperty("Username"), Prop.getProperty("Password"));
}


@AfterClass
public void Closeapplication() {
	driver.quit();
}


}