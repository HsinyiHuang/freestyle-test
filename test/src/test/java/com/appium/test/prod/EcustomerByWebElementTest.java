package com.appium.test.prod;


import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class EcustomerByWebElementTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
		File app = new File("/Users/Hsinyi/git/appium/sample-code/sample-code/apps/TestApp/build/release-iphonesimulator/esunSIT.app");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
	    capabilities.setCapability(MobileCapabilityType.APP, app);
	    
	    driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void findByElementsTest() throws InterruptedException {
		WebElement element =  driver.findElement(By.name("Allow"));
		element.click();
		
		Thread.sleep(3000);
		
		element = driver.findElement(By.name("確定"));
		element.click();
		
		
		element = driver.findElement(By.name("直接開始體驗"));
		element.click();
		
		element = driver.findElement(By.name("完成"));
		element.click();
		
		element = driver.findElement(By.name("我知道了 !"));
		element.click();
		
		element = driver.findElement(By.name("side menu btn"));
		
		element.click();
		
		element = driver.findElement(By.name("玉山e客服"));
		element.click();
		
		Thread.sleep(5000);

		element = driver.findElement(By.name("確定"));
		element.click();
		
		element = driver.findElement(By.name("請使用手機內建語音或文字輸入您的問題"));
		element.sendKeys("Hi");

		element = driver.findElement(By.name("Return"));
		element.click();
		
		Thread.sleep(2000);
		
		element = driver.findElement(By.name("請使用手機內建語音或文字輸入您的問題"));
		element.sendKeys("這是WebElement測試");

		element = driver.findElement(By.name("Return"));
		element.click();
		

		Thread.sleep(2000);
		
		element = driver.findElement(By.name("離開"));
		element.click();
		
		try {
			Thread.sleep(8000);	
			element = driver.findElement(By.name("《重啟對談》"));
		} catch (Exception e) {
			assertTrue(false);
		}
		
	}
}
