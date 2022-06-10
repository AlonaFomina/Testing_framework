package scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _06_RadioButtonTest extends Base {

    @Test(priority = 1, description = "TC0002: Validate Facebook Gender Radio Buttons")
    public void testFacebookRadioButton() {
        driver.get("https://www.facebook.com/");
        Waiter.pause(2);
        faceBookLoginPage.createNewAccountLink.click();
        Waiter.pause(2);
        for (WebElement element : faceBookLoginPage.genderRadioButtons) {
            Assert.assertTrue(element.isEnabled());
            element.click();
            //Assert.assertTrue(!element.isSelected());
            softAssert.assertTrue(!element.isSelected());
        }
        Waiter.pause(2);
        //faceBookLoginPage.genderRadioButtons(0).click();
        //Assert.assertTrue(faceBookLoginPage.genderRadioButtons.get(0).isSelected());

        Waiter.pause(2);
        faceBookLoginPage.genderRadioButtons.get(1).click();
       // Assert.assertTrue(faceBookLoginPage.genderRadioButtons.get(1).isSelected());
    }

    @Test(priority = 1, description = "TC0003: Creating a new account")
    public void creatingANewAccount() {
        driver.get("https://www.facebook.com/");
//        Waiter.pause(2);
        explicitWait.until(ExpectedConditions.elementToBeClickable(faceBookLoginPage.createNewAccountLink));
        faceBookLoginPage.createNewAccountLink.click();
        explicitWait.until(ExpectedConditions.visibilityOf(faceBookLoginPage.loginMenu));

        String[] userInfo = {"John", "Doe", "johndoe555@mail.com", "johndoe555@mail.com", "abc1234"};
        int i = 0;
        for (WebElement element : faceBookLoginPage.inputInfo) {
            element.sendKeys(userInfo[i++]);
        }

        faceBookLoginPage.genderRadioButtons.get(1).click();
        faceBookLoginPage.singIn.click();

    }

}
