package appium.tips.connectiviy;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ConnectivityTest {

	@Test
	public void test() throws MalformedURLException {
		File app = new File("apps/Connectivity.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "0010754427");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);

		// turn on all (data and wi-fi)
		driver.setConnection(Connection.ALL);
		assertEquals(Connection.ALL, driver.getConnection());
		
		// turn off all (data and wi-fi)
		driver.setConnection(Connection.NONE);
		assertEquals(Connection.NONE, driver.getConnection());
		
		// turn on airplane
		driver.setConnection(Connection.AIRPLANE);
		assertEquals(Connection.AIRPLANE, driver.getConnection());
		
		// turn on data
		driver.setConnection(Connection.DATA);
		assertEquals(Connection.DATA, driver.getConnection());
		
		// tunr on wi-fi
		driver.setConnection(Connection.WIFI);		
		assertEquals(Connection.WIFI, driver.getConnection());
	}
}
