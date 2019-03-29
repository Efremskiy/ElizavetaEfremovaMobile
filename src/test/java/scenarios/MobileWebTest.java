package scenarios;

import enums.WebTestData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static setup.Driver.*;

@Test(groups = "web")
public class MobileWebTest {

    /**
     * This test checks if desired site is successfully loaded.
     * @throws Exception
     */
    @Test(description = "Open website")
    public void connectingSiteTest() throws Exception {
        //Connecting the site and waiting for it to load
        getDriver().get(getSut());
        getWait().until(ExpectedConditions.urlToBe(getSut() + "/"));
        //Checking if exactly desired site is connected
        Assert.assertEquals(getDriver().getTitle(), WebTestData.TEST_PAGE_TITLE.toString());
    }
}
