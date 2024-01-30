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
import io.appium.java_client.android.AndroidDriver;

public class emulatorDemo {

	AppiumDriver<MobileElement> driver;
	@BeforeTest 
	public void desiredCapabilities() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capability=new DesiredCapabilities();
		File file=new File("C:\\Users\\Bablu\\Desktop\\MobileAutomationTest\\amazon.apk");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "14");
		capability.setCapability("deviceName", "emulator-5554");
		capability.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		capability.setCapability("app",file.getAbsolutePath());
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		Thread.sleep(5000);
	}

	@Test
	public void simpleTest() throws InterruptedException
	{
		driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
}
