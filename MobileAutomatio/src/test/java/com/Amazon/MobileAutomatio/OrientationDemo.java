package com.Amazon.MobileAutomatio;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrientationDemo {

	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void desiredCapabilities() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "9");
		capability.setCapability("deviceName", "c5fd9b61");
		capability.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		// here we doing orientation of the device
		capability.setCapability("orientation", "LANDSCAPE");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
	}

	@Test
	public void simpleTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/sso_continue")).click();
		
	}

	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
}
