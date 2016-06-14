package appium.tips.screen;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ScreenSizeTest {

	@Test
	public void testScreenSize() throws IOException {
		File app = new File("apps/screen.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		// informamos o nome do dispositivo onde o teste será executado
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "0010754427");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);

		
		Dimension dimension = driver.manage().window().getSize();
		int x = dimension.getHeight();
		int y = dimension.getWidth();
	
		driver.swipe(x /2, y - 1, x / 2, 1, 500);
		
		String heightDevice = String.valueOf(dimension.getHeight());
		String widthDevice = String.valueOf(dimension.getWidth());

		String heightScreen = driver.findElement(By.id("com.eliasnogueira.screensize:id/txt_height")).getText();
		String widthScreen = driver.findElement(By.id("com.eliasnogueira.screensize:id/txt_width")).getText();

		assertEquals(heightDevice, heightScreen);
		assertEquals(widthDevice, widthScreen);
		
		
		
		driver.quit();
	}

}
