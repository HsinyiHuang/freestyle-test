package com.appium.test.prod;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class EcustomerByMobileElementTest {

	private IOSDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "iOS");
		desiredCapabilities.setCapability("platformVersion", "11.0");
		desiredCapabilities.setCapability("deviceName", "iPhone 7 Plus");
		desiredCapabilities.setCapability("app",
				"/Users/Hsinyi/git/appium/sample-code/sample-code/apps/TestApp/build/release-iphonesimulator/esun.app");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver = new IOSDriver<MobileElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void ecustomerTest() throws InterruptedException {

		MobileElement element = (MobileElement) driver.findElementByAccessibilityId("Allow");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("確定");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("直接開始體驗");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("完成");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("我知道了 !");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("side menu btn");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("玉山e客服");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("確定");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("請使用手機內建語音或文字輸入您的問題");

		element.sendKeys("Hi");

		element = (MobileElement) driver.findElementByAccessibilityId("Return");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("請使用手機內建語音或文字輸入您的問題");
		element.sendKeys("這是MobileElement測試");

		element = (MobileElement) driver.findElementByAccessibilityId("Return");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("離開");
		element.click();

		element = (MobileElement) driver.findElementByAccessibilityId("《重啟對談》");

	}
}
