package com.generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.*;

public class ExtentReport {

	private static ExtentReports extent;

	public static ExtentReports getInstance(String className) {
		if (extent == null) {
			extent = createInstance(className);
		}
		return extent;
	}
	/**
	* This is method is used to create extent instance file for extent report
	*/
	public static ExtentReports createInstance(String className) {
		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm").format(new Date());
		String fileName;
		fileName = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "java" + File.separator + "Reports" + File.separator + className + "_" + timeStamp + "_" + ".html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);
		extent = new ExtentReports();
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public static void quitExtent() {
		extent.flush();
		extent = null;
	}
	
	public void log(String log) {
		// TODO Auto-generated method stub
		System.out.println(log);
	}
}