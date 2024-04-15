package mobileABFlex;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public interface ExtentReportManager {
	
    
    @BeforeSuite
    public void beforeSuite();

    @BeforeMethod
    public void beforeMethod();

    @AfterMethod
    public void afterMethod(ITestResult result);

    @AfterSuite
    public void afterSuite();


}
