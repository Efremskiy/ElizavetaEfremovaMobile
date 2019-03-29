package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static setup.TestProperties.getProperty;

/**
 * This class sets up the driver, which is singleton.
 */
public class Driver {
    private static AppiumDriver driverInstance;
    private static WebDriverWait waitInstance;
    private static DesiredCapabilities capabilities;

    // Properties to be read
    private static String AUT; // (mobile) app under testing
    private static String SUT; // site under testing
    private static String TEST_PLATFORM;
    private static String DRIVER_URL;
    private static String DEVICE_NAME;

    private Driver() {}

    //Reading properties
    public static void setProperties() throws IOException {
        AUT = getProperty("aut");
        SUT = getProperty("sut");
        TEST_PLATFORM = getProperty("platform");
        DRIVER_URL = getProperty("driver");
        DEVICE_NAME = getProperty("deviceName");
    }

    //Setting capabilities
    private static void setCapabilities() throws Exception {
        setProperties();
        capabilities = new DesiredCapabilities();
        String browserName;
        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch(TEST_PLATFORM){
            case "Android": {
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;
            }
            case "iOS": {
                browserName = "Safari";
                break;
            }
            default: {
                throw new Exception("Unknown mobile platform");
            }
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, web (or hybrid)
        if(AUT != null && SUT == null){
             //Native
             File app = new File(AUT);
             capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if(SUT != null && AUT == null){
            // Web
             capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        }else{
            throw new Exception("Unclear type of mobile app");
        }
    }

    //Defining new driver instance or giving the existing one, if any
    public static AppiumDriver getDriver() throws Exception {
        if(driverInstance == null) {
            setCapabilities();
            driverInstance = new AppiumDriver(new URL(DRIVER_URL), capabilities);
            waitInstance = new WebDriverWait(driverInstance, 10);
        }
        return driverInstance;
    }

    //Defining new wait instance or giving the existing one, if any
    public static WebDriverWait getWait() throws Exception {
        if(waitInstance == null) {
            getDriver();
        }
        return waitInstance;
    }

    public static String getSut() {
        return SUT;
    }
}
