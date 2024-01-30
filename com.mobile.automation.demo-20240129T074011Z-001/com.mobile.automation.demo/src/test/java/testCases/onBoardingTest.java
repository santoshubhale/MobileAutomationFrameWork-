package testCases;

import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.PropertyReader;

import pageObjects.onBoardingPage;

public class onBoardingTest extends BaseClass {
	
	onBoardingPage onboard = new onBoardingPage();
	PropertyReader reader = new PropertyReader();
	
	
	@Test(priority=1)
	public void onboardFlow()
	{
		onboard.skipSignInElement(driver);
		onboard.cartElement(driver);
	    String emailid=reader.getStringTestData("Email_ID");
	    onboard.HomeElement(driver);
		
	}
	
	
	@Test(priority=0)
	public void onboardFlowing()
	{
		onboard.skipSignInElement(driver);
		onboard.cartElement(driver);
		
	}
	
	
	
}
