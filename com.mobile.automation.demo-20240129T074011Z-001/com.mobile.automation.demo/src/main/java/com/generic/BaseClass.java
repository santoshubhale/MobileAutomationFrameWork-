package com.generic;

import java.io.File;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseClass {

	public AppiumDriver<MobileElement> driver;
	protected static ExtentReports extent;
	protected static ExtentTest pNode;
	static PropertyReader pr = new PropertyReader();
	public static String platformName = pr.getStringTestData("platformName");

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext suite) throws Exception {

		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm").format(new Date());
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "src"
				+ File.separator + "test" + File.separator + "java" + File.separator + "Reports" + File.separator
				+ getClass().getSimpleName() + "_" + timeStamp + "_" + platformName + ".html");

		htmlReporter.config().setChartVisibilityOnOpen(false);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		String fileName = (suite.getSuite().getName().equalsIgnoreCase("Default Suite")) ? getClass().getSimpleName()
				: suite.getSuite().getName();
		extent = ExtentReport.getInstance(fileName);

	}

	@BeforeClass(alwaysRun = true)
	public void beforeClasss() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		System.out.println("Platform name is: " + platformName);
		if (platformName.equals("Android")) {
			File AndroidApp = new File(pr.getStringTestData("Apk_file_path"));
			capabilities.setCapability("platformName", pr.getStringTestData("platformName"));
			capabilities.setCapability("deviceName", pr.getStringTestData("deviceNameForAndroid"));
			capabilities.setCapability("platformVersion", pr.getStringTestData("platformVersionForAndroid"));
			capabilities.setCapability("appPackage", pr.getStringTestData("appPackageNameForAndroid"));
			capabilities.setCapability("appActivity", pr.getStringTestData("appActivityNameForAndroid"));
			capabilities.setCapability("app", AndroidApp.getAbsolutePath());
			URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(appiumURL, capabilities);
		} else {
			File iOSApp = new File(pr.getStringTestData("Ipa_file_path"));
			capabilities.setCapability("platformName", pr.getStringTestData("platformName"));
			capabilities.setCapability("platformVersion", pr.getStringTestData("platformVersionForIos"));
			capabilities.setCapability("deviceName", pr.getStringTestData("deviceNameForIos"));
			capabilities.setCapability("automationName", "XCUITest");
			capabilities.setCapability("udid", pr.getStringTestData("UDID"));
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("useNewWDA", true);
			capabilities.setCapability("bundleId", pr.getStringTestData("bundleIDForIos"));
			capabilities.setCapability("usePreBuiltWDA", false);
			URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new IOSDriver<MobileElement>(appiumURL, capabilities);
		}
		
		
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		System.out.print("START TEST: " + method.getName() + "\n");
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {
			pNode = extent.createTest(result.getName());
			String code = "TestMethodName: " + result.getName();
			Markup m = MarkupHelper.createCodeBlock(code);
			pNode.pass(m);
			System.out.print(result.getName() + ": Executed Successfully");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			pNode = extent.createTest(result.getName());

			String code = "TestMethodName: " + result.getName() + "\n" + "Reason: " + result.getThrowable().toString();
			System.out.print(code);
			Markup m = MarkupHelper.createCodeBlock(code);
			MarkupHelper.createCodeBlock(result.getName());
			pNode.fail(m);
			String screenshotPath = ScreenShot.getScreenhot(driver, result.getName());
			pNode.addScreenCaptureFromPath(screenshotPath);
			System.out.print("\nScreenshot path is:" + screenshotPath);
			System.out.print("\n" +result.getName() + "  :Execution Failed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			pNode = extent.createTest(result.getName());
			String code = "TestMethodName: " + result.getName();
			Markup m = MarkupHelper.createCodeBlock(code);
			pNode.skip(m);
			System.out.print(result.getName() + ": Execution Skipped");
		}
		extent.flush();
		System.out.print("\nEND TEST: " + result.getName() + "\n");
		driver.resetApp();
	}


	@AfterClass(alwaysRun = true)
	public void afterClassRun() {
		driver.closeApp();
	}
}
