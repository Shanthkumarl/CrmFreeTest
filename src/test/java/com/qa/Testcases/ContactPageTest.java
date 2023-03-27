package com.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.PomPages.ContactPage;
import com.qa.PomPages.HomePage;
import com.qa.PomPages.LoginPage;
import com.qa.Util.TestUtile;
import com.qa.base.TestBase;

import net.bytebuddy.description.type.TypeDescription.ArrayProjection;

public class ContactPageTest extends TestBase {

private static final boolean False = false;
LoginPage Lp;
ContactPage Cp;
HomePage Hp;
TestUtile Tu;
String Sheetname="Contacts";

public ContactPageTest() {
  super();
}


@BeforeMethod
public void setup() {
	initailzation();
	Tu=new TestUtile();
	Cp=new ContactPage();
	Lp=new LoginPage();
	Hp=new HomePage();
	Hp=Lp.ValidateLoginPage(Prop.getProperty("Username"), Prop.getProperty("Password"));
	Tu.switchToFrame();
    Cp= Hp.ClickOnContactsLink();
}

@Test(priority = 1)
public void VerifyContactLabel() {
	Assert.assertTrue(Cp.verifycontactLabel());
}

@Test(priority = 2)
public void SelectCheckBox() {
	Cp.selectCheckbox();
	System.out.println("checkbox is selected");
}

@DataProvider
public Object[][] GetCrmTestdata(){
	Object data[][]=TestUtile.getTestData(Sheetname);
	return data;
}

@Test(priority = 3, dataProvider = "GetCrmTestdata", enabled = False)
public void ValidateCreateNewContact(String title,String firstname,String lastname,String company) throws InterruptedException {
	
	Hp.ClickOnNewContactLink();
	//Cp.creatNewContact("Miss", "Pavan", "Reddy", "xxx");
	Cp.creatNewContact(title, firstname, lastname, company);
}

@AfterMethod
public void CloseApplication(){
	driver.quit();
}


}
