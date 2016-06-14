package appium.tips.connectiviy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ConnectivityTest {

	@Test
	public void test() throws MalformedURLException {
		File app = new File("apps/Connectivity.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		// informamos o nome do dispositivo onde o teste será executado
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);

		// inicia com wifi e dados moveis ligados, e com modo avião desligado 
		NetworkConnectionSetting ncs = new NetworkConnectionSetting(false, true, true);
		driver.setNetworkConnection(ncs);
		
		// desliga wi-fi
		ncs.setWifi(false);
		driver.setNetworkConnection(ncs);
		
		// desliga dados moveis
		ncs.setData(false);
		driver.setNetworkConnection(ncs);
		
		// liga o modo aviao
		ncs.setAirplaneMode(true);
		driver.setNetworkConnection(ncs);
		
		// desliga modo aviao
		ncs.setAirplaneMode(true);
		driver.setNetworkConnection(ncs);
		
		// liga dados moveis
		ncs.setData(true);
		driver.setNetworkConnection(ncs);
		
		// liga wi-fi
		ncs.setWifi(true);
		driver.setNetworkConnection(ncs);		
	}
}
