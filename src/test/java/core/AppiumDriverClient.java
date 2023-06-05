package core;

import com.google.gson.JsonObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverClient {
    public static JsonObject testData;
    public static core.JsonReader reader = new JsonReader();
    public static AppiumDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        File f = new File("BitbarSampleApp.apk");
        String apk = "";
        if (isWindows()) {
            apk = f.getAbsoluteFile().toString();
        } else if (isMac()) {
            apk = f.getAbsoluteFile().toString();
        }
        JsonObject emulatorInfo;
        emulatorInfo = reader.readCapabilities();
        int port = emulatorInfo.get("port").getAsInt();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, emulatorInfo.get("deviceOS").getAsString());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, emulatorInfo.get("deviceOSVersion").getAsString());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorInfo.get("avdName").getAsString());
        caps.setCapability(MobileCapabilityType.APP, apk);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("avd", emulatorInfo.get("avdName").getAsString());
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);

        URL url = new URL("http://localhost:" + port);
        driver = new AppiumDriver(url, caps);

        testData = reader.readConfigData();
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win");
    }

    public static boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("mac");
    }
}