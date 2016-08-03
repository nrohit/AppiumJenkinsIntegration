package com.appium.jenkins.jenkinsintegration;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.ExecuteException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumIntegrationTest {
	
	@BeforeClass
	public void startAppiumServer() throws ExecuteException, IOException, InterruptedException{
		new AppiumServer().startAppium();
	}

	@Test
		public void testLaunch() throws InterruptedException, IOException {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, System.getProperty("PlatformName"));
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, System.getProperty("PlatformVersion"));
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			cap.setCapability(MobileCapabilityType.APP, "/Users/rohit/Desktop/Consumer.apk");
			cap.setCapability("app_package", "com.driveu.customer");
			cap.setCapability("app_activity", "com.driveu.customer.activity.ConfigScreenActivity");
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			new AppiumServer().adbPermisions();
			Thread.sleep(20000);
		}
	
	@AfterClass
	public void stopAppiumServer() throws IOException{
		new AppiumServer().stopAppium();
	}
	}

