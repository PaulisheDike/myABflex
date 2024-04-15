package mobileABFlex;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("myABflex");
		options.setApp("C:\\Users\\gpaul\\eclipse-workspace\\ABFlexTesting\\src\\test\\java\\resources\\app-armeabi-v7a-release (2).apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
	}
	
	@AfterClass
	public void teardown() {
		if(driver != null) {
			driver.quit();
			System.out.println("Teardown successful");
		}
	}

}
