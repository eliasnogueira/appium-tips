package appium.tips.language;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LanguageTesting {

	@Rule
	public TestName name = new TestName();
	
	private AndroidDriver<MobileElement> driver;
	private DesiredCapabilities dc;
	File app = new File("apps/Internacionalization.apk");
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testLanguage_ptBR() throws IOException, InterruptedException {
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		
		dc.setCapability("language", "pt");

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
		
		driver.findElement(By.id("com.eliasnogueira.internacionalizacao:id/email_sign_in_button")).click();
		takesScreenshot(name.getMethodName());
		
		Thread.sleep(2000);
	}
	
	@Test
	public void testLanguage_enUS() throws IOException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("language", "en");
		
		
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		
		
		
		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
		
		driver.findElement(By.id("com.eliasnogueira.internacionalizacao:id/email_sign_in_button")).click();
		takesScreenshot(name.getMethodName());
		
		Thread.sleep(2000);
	}
	

	
	private void takesScreenshot(String testName) throws IOException {
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshots/" + testName + ".png"));
	}

}
