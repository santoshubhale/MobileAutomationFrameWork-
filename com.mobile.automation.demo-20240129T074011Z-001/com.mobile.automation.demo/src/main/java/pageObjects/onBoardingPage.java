package pageObjects;

import java.util.concurrent.TimeUnit;

import com.generic.PropertyReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class onBoardingPage {
	PropertyReader prop = new PropertyReader();

	public void waits(AppiumDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void skipSignInElement(AppiumDriver<MobileElement> driver)  {
		this.waits(driver);
	
		driver.findElementById(prop.getStringForElements("skipSignInElement")).click();
		
	}
	
	public void cartElement(AppiumDriver<MobileElement> driver)  {
		this.waits(driver);
		driver.findElementById(prop.getStringForElements("cartElement")).click();
	}
	
	public void HomeElement(AppiumDriver<MobileElement> driver)  {
		this.waits(driver);
		driver.findElementById(prop.getStringForElements("HomeIcon")).click();
	}
	
}