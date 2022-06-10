package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropdownHandler;
import utilities.Waiter;

public class _07_DropdownTest extends Base{
    @Test(priority = 1, description = "TC00001: Validate FaceBook sing in error message for password")
    public void testUnsecurePasswordErrorMessage(){
        driver.get("https://www.facebook.com/");

        faceBookLoginPage.createNewAccountLink.click();

        faceBookLoginPage.firstNameInputBox.sendKeys("John");
        faceBookLoginPage.lastNameInputBox.sendKeys("Doe");
        faceBookLoginPage.emailOrPhoneInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookLoginPage.emailReEnterInputBox.sendKeys("johndoe55555@gmail.com");
        faceBookLoginPage.passwordInputBox.sendKeys("abcd1234");

        //to be able to select an option from Dropdown we need an instance fromSelect class
//        Select monthSelector = new Select(faceBookLoginPage.monthDropDown);
//       // monthSelector.selectByValue("4");//selection by value
//        //monthSelector.selectByVisibleText("Apr");// by visible text
//
//        monthSelector.selectByValue("4");
//
//        Select daySelector = new Select(faceBookLoginPage.dayDropDown);
//        daySelector.selectByIndex(29);
//        Select yearSelector = new Select(faceBookLoginPage.yearDropDown);
//        yearSelector.selectByVisibleText("1986");

        DropdownHandler.selectOptionByIndex(faceBookLoginPage.monthDropDown,3);
        DropdownHandler.selectOptionByVisibleText(faceBookLoginPage.dayDropDown,"1");
        DropdownHandler.selectOptionByValue(faceBookLoginPage.yearDropDown,"1990");

        faceBookLoginPage.genderRadioButtons.get(1).click();
        faceBookLoginPage.singIn.click();
        String expected = "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";

        Waiter.waitForUntilTextToBEPresentInElement(driver,30,faceBookLoginPage.errorMessage,expected);

        Assert.assertEquals(faceBookLoginPage.errorMessage.getText(),expected,"Error message has issues");
        Waiter.pause(5);

    }

    @Test(priority = 2,description = "TC0002: Validate Expedia dropdowns")
    public void testExpediaDropDowns(){
        driver.get("https://www.expedia.com/");

        expediaSearchPage.moreTravelDropdown.click();
        expediaSearchPage.flights.click();

        //manual captcha solution

        Waiter.waitForVisibilityOfElement(driver,expediaSearchPage.flightTypesDropdown,120);
        expediaSearchPage.flightTypesDropdown.click();

        expediaSearchPage.flightOptions.get(1).click();

        Assert.assertEquals(expediaSearchPage.flightTypesDropdown.getText(),"Premium economy");

    }

    @Test(priority = 3,description = "TC0003: Validate Ebay Dropdown")
    public void testEbayDropdown(){

    }

}
