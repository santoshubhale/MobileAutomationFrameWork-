package testCases;

import org.testng.annotations.Test;

import com.generic.BaseClass;

import pageObjects.electonicPageObjects;

public class electronicPageTests extends BaseClass {

	electonicPageObjects electonspage = new electonicPageObjects();
	
	
	@Test
	public void VerifyElectronsPage()
	{
		electonspage.elctronicItem(driver);
		
	}
}
