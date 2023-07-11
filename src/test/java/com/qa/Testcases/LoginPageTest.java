package com.qa.Testcases;

import java.util.HashMap;

import org.seleniumhq.jetty9.util.security.Credential;
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
	System.out.println("login is suuccesfully ");
}


/*public static HashMap<String, String> Hashmaptogetdata() {
	HashMap<String, String>usermap=new HashMap<String, String>();
	usermap.put("admin", "admin:admin@123");
	usermap.put("seller", "seller:seller@123");
	usermap.put("customer", "customer:customer@123");
	
	return usermap;
	}

public static String getusername(String role) {
	String credentail = Hashmaptogetdata().get(role);
	return credentail.split(":")[0];
}

public static String getPassword(String role) {
	String credentail = Hashmaptogetdata().get(role);
	return credentail.split(":")[1];
}
@Test
public void login() {
	Hp=lp.ValidateLoginPage(getusername("customer"), getPassword("customer"));
}
*/


@AfterClass
public void Closeapplication() {
	driver.quit();
}


}