package test1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calculator {
	
	
		 
		public void setUp() throws Exception {
			WebDriver driver;
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability("deviceName", "OSScube");
		    capabilities.setCapability("platformName", "Android");
		    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		    capabilities.setCapability("platformVersion", "4.4.2");
		    capabilities.setCapability("appPackage", "com.android.chrome");
		    capabilities.setCapability("appActivity","com.google.android.apps.chrome.ChromeTabbedActivity");
		    capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
		    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get("http://www.google.com");
	
	}
}
