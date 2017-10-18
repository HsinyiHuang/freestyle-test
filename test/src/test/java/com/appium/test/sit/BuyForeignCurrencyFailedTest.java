package com.appium.test.sit;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.remote.MobileCapabilityType;


public class BuyForeignCurrencyFailedTest {

	private IOSDriver<MobileElement> driver;
	
	@Before
	public void setUp() throws Exception {
		
		File app = new File("/Users/Hsinyi/git/appium/sample-code/sample-code/apps/TestApp/build/release-iphonesimulator/esunSIT.app");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
	    capabilities.setCapability(MobileCapabilityType.APP, app);
	    
	    driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void findByElementsTest() throws InterruptedException {

		WebElement element =  driver.findElement(By.name("Allow"));
		element.click();
				
		element = driver.findElement(By.name("確定"));
		element.click();
		
		element = driver.findElement(By.name("身分證字號"));
		element.sendKeys("D122206304");

		element = driver.findElement(By.name("使用者名稱"));
		element.sendKeys("esbloan");

		element = driver.findElement(By.name("使用者密碼"));
		element.sendKeys("esb1313");

		element = driver.findElement(By.name("驗證碼"));
		element.sendKeys("12345");
		
		driver.getKeyboard().sendKeys(Keys.RETURN);


		//判斷是否已登入
		List<MobileElement> loginElements = driver.findElements(By.name("確定"));
		
		if(loginElements.size() > 0) {
			loginElements.get(0).click();
		} 
		
		element = driver.findElement(By.name("side menu btn"));
		element.click();

		element = driver.findElement(By.name("外幣匯兌"));
		element.click();

		element = driver.findElement(By.name("買外幣"));
		element.click();
		
		(new TouchAction(driver)).press(180, 504).moveTo(10, -367).release().perform();

		element = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"我已閱讀並同意上述規範\"]");
		element.click();

		element = (MobileElement) driver
				.findElementByXPath("//XCUIElementTypeOther[@name=\"主要\"]/XCUIElementTypeTextField");
		element.sendKeys("100000");

		element = (MobileElement) driver.findElement(By.name("下一步"));
		element.click();

		element = (MobileElement) driver.findElement(By.name("確定"));
		element.click();

		List<MobileElement> expectedElements = driver.findElements(By.name("餘額不足"));
		
		assertThat(expectedElements.size(), equalTo(1));
		

		
	}
}
