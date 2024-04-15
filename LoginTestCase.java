package mobileABFlex;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LoginTestCase extends BaseTest implements ExtentReportManager {
	
	public static ExtentReports extent = new ExtentReports();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    String userid = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]";
	String pass = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]";
	String acc_no = "0102362770";
	
	
	@Test
	public void ValidUserIdValidPassword() {
		//driver.findElement(AppiumBy.accessibilityId("Views")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("GET STARTED")));
		
		driver.findElement(AppiumBy.accessibilityId("GET STARTED")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Login")));
		driver.findElement(AppiumBy.accessibilityId("Login")).click();
		driver.findElement(By.xpath(userid)).sendKeys(acc_no);
		driver.findElement(By.xpath(pass)).sendKeys("Nigeria@1");
		driver.findElement(AppiumBy.accessibilityId("Login")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Paul")));
		Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Paul")).isDisplayed());
		
		
	}
	
	 
	
	 

	@Override
	public void beforeSuite() {
    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
	}

	@Override
	public void beforeMethod() {
		
        ExtentTest extentTest = extent.createTest(getClass().getSimpleName() + " - " + Thread.currentThread().getName());
        test.set(extentTest);
		
	}

	@Override
	public void afterMethod(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
            test.get().fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.get().pass("Test passed");
        } else {
            test.get().skip("Test skipped");
        }
		
	}

	@Override
	public void afterSuite() {
		extent.flush();
	}
	


}
