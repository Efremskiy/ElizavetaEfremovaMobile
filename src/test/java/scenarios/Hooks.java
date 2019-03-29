package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static setup.Driver.getDriver;
import static setup.TestProperties.setPropertyFileName;

/**
 * This class transfers corresponding property file name further, sets up the driver and tears it down in the end.
 */
@Test(groups = {"native", "web"})
public class Hooks {

    @Parameters("propertyFileName")
    @BeforeSuite
    public void setUp(String propertyFileName) throws Exception {
        setPropertyFileName(propertyFileName);
        getDriver();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        getDriver().quit();
    }
}
