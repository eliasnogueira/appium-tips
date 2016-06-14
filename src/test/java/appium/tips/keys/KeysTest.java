package appium.tips.keys;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class KeysTest {

	@Test
	public void testeKeysVolume() throws MalformedURLException {
		File app = new File("apps/Volume.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		// informamos o nome do dispositivo onde o teste será executado
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
		
		// localizando o componente de texto do percentual de volume
		MobileElement textoVolume = (MobileElement) 
				driver.findElement(By.id("com.eliasnogueira.buttons:id/txtVolumePer"));
		
		// aumentar o volume e validar a mensagem
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_UP);
		assertEquals("Volume: 14%", textoVolume.getText());
		
		// diminuir o volume e validar a mensagem
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		assertEquals("Volume: 0%", textoVolume.getText());
		
	}
	
	@Test
	@Ignore
	public void testeSeekbar() throws MalformedURLException {
		File app = new File("apps/Volume.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		// informamos o nome do dispositivo onde o teste será executado
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), dc);
		TouchAction action = new TouchAction(driver);
		
		MobileElement seekBar = (MobileElement) driver.findElement(By.id("com.eliasnogueira.buttons:id/seekBar"));
		
		int start = seekBar.getLocation().getX();
		int end = seekBar.getSize().getWidth();
		int y = seekBar.getLocation().getY();
		
		System.out.println(start);
		System.out.println(end);
		System.out.println(y);
		
		int moveTo = (int)(end * 0.4);
		action.press(start, y).moveTo(moveTo, y).release().perform();
	}

}
