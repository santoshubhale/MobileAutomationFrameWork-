package com.Amazon.MobileAutomatio;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
public class coordinatesDemo {
	
	AppiumDriver<MobileElement> driver;
	@BeforeTest 
	public void desiredCapabilities() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capability=new DesiredCapabilities();
	// 	here we installing the build using the file path 
		File file = new File("C:\\Users\\Bablu\\Desktop\\MobileAutomationTest\\amazon.apk");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "9");
		capability.setCapability("deviceName", "c5fd9b61");
		capability.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
	//	here we deletes the existing build after every execution
		capability.setCapability("fullReset", false);
		capability.setCapability("app",file.getAbsolutePath());
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	}

	@Test
	public void simpleTest() throws InterruptedException
	{
		//Thread.sleep(2000);
		//driver.findElementById("com.amazon.mShop.android.shopping:id/skip_sign_in_button").click();
		Thread.sleep(2000);
	//	driver.findElementByXPath("//*[@text='Mobiles']").click();
       this.coordinatesMethod(402,2252);
       Thread.sleep(10000);
	}
	
	public void coordinatesMethod(int x, int y) {
		new TouchAction(driver).tap(PointOption.point(x,y)).release().perform();
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
}
