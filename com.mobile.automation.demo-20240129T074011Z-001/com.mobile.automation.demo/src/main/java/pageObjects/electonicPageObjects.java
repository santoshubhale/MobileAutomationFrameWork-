package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import java.util.concurrent.TimeUnit;

import com.generic.PropertyReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class electonicPageObjects {
	PropertyReader prop = new PropertyReader();
	
	public void waits(AppiumDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void elctronicItem(AppiumDriver<MobileElement> driver)  {
		this.waits(driver);
		String emailid=prop.getStringTestData("Email_ID");
		driver.findElementById(prop.getStringForElements("ElectonicHomePage")).click();
		
	}
	
	public void cartElement(AppiumDriver<MobileElement> driver)  {
		this.waits(driver);
		driver.findElementById(prop.getStringForElements("cartElement")).click();
	}
}
