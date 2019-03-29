package scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static enums.NativeTestData.*;
import static setup.Driver.getDriver;

@Test(groups = "native")
public class MobileNativeTest {

    /**
     * This test clicks on "Add contact" button and checks if all UI elements are present.
     */
    @Test
    public void clickOnButtonTest() throws Exception {
        //Clicking "Add contact" button
        getDriver().findElement(By.id(ADD_CONTACT_BUTTON.toString())).click();
        //Checking all necessary UI elements
        Assert.assertTrue(getDriver().findElement(By.id(TARGET_ACCOUNT.toString())).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.id(CONTACT_NAME.toString())).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.id(CONTACT_PHONE.toString())).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.id(CONTACT_EMAIL.toString())).isDisplayed());
        Assert.assertTrue(getDriver().findElement(By.id(SAVE_BUTTON.toString())).isDisplayed());
        //Checking if keyboard is opened
        Assert.assertNotNull(getDriver().getKeyboard());
    }
}
