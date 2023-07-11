package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.github.dockerjava.api.model.Config;
import com.qa.Util.TestUtile;
import com.qa.Util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
public static Properties Prop;
public  static WebDriver driver;
public static EventFiringWebDriver e_firingdriver;
public static WebEventListener eventlistener;
public TestBase(){
	try {
		Prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\CrmTesting\\src\\main\\java\\com\\qa\\config\\config.Properties");
		Prop.load(fis);
       		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
}

public static void initailzation() {
 String Browsername = Prop.getProperty("Browser");
 if (Browsername.equals("chrome")) {
	 WebDriverManager.chromedriver().setup();
	
	driver=new ChromeDriver();
 }
 else if (Browsername.equals("ff")) {
	 WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
	
}
 e_firingdriver=new EventFiringWebDriver(driver);
 eventlistener=new WebEventListener();
 e_firingdriver.register(eventlistener);
 driver=e_firingdriver;
 
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
 driver.manage().timeouts().pageLoadTimeout(TestUtile.PAGE_LOAD_TIME,TimeUnit.SECONDS);
 driver.manage().timeouts().implicitlyWait(TestUtile.LOAD_TIME,TimeUnit.SECONDS);
 
 driver.get(Prop.getProperty("url"));
}

}

