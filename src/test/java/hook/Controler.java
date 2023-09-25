package hook;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controler {

    private static AppiumDriver driver;
    private static Logger logger = LoggerFactory.getLogger(Controler.class);
    //private static String appPackage;
    public static AppiumDriver setUp(String appActivity) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");

        try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, capabilities);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			return null;

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
			return null;
		}



        return driver;
    }
}
