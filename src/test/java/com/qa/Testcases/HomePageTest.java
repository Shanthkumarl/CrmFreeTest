package com.qa.Testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.PomPages.ContactPage;
import com.qa.PomPages.HomePage;
import com.qa.PomPages.LoginPage;
import com.qa.Util.TestUtile;
import com.qa.base.TestBase;

public class HomePageTest extends TestBase {
LoginPage Lp;
HomePage Hp;
TestUtile Tu;
ContactPage Cp= new ContactPage();
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		initailzation();
		Lp=new LoginPage();
		Hp=Lp.ValidateLoginPage(Prop.getProperty("Username"), Prop.getProperty("Password"));
		Tu=new TestUtile();
	}
	
	
	@Test(priority = 1)
	public void HomePageTittleTest () {
		String HomepageTittle = Hp.verifyHomePageTitle();
		Assert.assertEquals(HomepageTittle,"CRMPRO","homepage Title is not Matched!");
	}
	
	@Test (priority = 2)
	public void VerfiyUserName() {
		//driver.switchTo().frame(0);not working 
		Tu.switchToFrame();
		String Name=Hp.VerifyCurrentUserName();
	Assert.assertEquals(Name,"  User: shanth kumar");
		//Assert.assertTrue(Hp.VerifyCurrentUserName());
	}
	
	@Test (priority = 3)
	public void clickOnContextLinkTest() {
		//Tu.switchToFrame();
		Cp =Hp.ClickOnContactsLink();
	}
	 
	@AfterClass
	public void CloseApplication() {
		driver.quit();
	}
}


