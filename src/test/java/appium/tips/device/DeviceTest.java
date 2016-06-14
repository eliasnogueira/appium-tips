package appium.tips.device;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DeviceTest {

	@Test
	public void testOnDevice() throws MalformedURLException {
		File app = new File("apps/DeviceSerial.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		// informamos o nome do dispositivo onde o teste será executado
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "0010754427");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);

		assertEquals("0010754427", driver.findElement(By.id("com.eliasnogueira.deviceserial:id/txt_device_serial")).getText());

		driver.quit();
	}
}
