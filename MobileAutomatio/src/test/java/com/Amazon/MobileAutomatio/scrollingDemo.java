package com.Amazon.MobileAutomatio;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static java.time.Duration.ofMillis;

public class scrollingDemo {

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
		capability.setCapability("fullReset", true);
		capability.setCapability("app",file.getAbsolutePath());
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capability);
	}

	@Test
	public void simpleTest() throws InterruptedException
	{
		Thread.sleep(5000);
		for(int i=1;i<=10;i++)
		{
			this.verticalSwipeByPercentages(0.80, 0.40, 0.20);
		}
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.amazon.mShop.android.shopping:id/bottom_tab_button_icon\"])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.amazon.mShop.android.shopping:id/cart_count")).click();
	}


	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);
		new TouchAction(driver).press(PointOption.point(anchor, startPoint))
		.waitAction(WaitOptions.waitOptions(ofMillis(1000))).moveTo(PointOption.point(anchor, endPoint))
		.release().perform();
	}


	@AfterTest
	public void quitDriver()
	{
		driver.quit();
	}
}

