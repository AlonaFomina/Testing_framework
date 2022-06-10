package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AlertHandler;
import utilities.Waiter;

public class _08_Alerts_Test extends Base{
    @Test(priority = 1,description = "Task-1")
    public void testEtsySingInModel(){
        driver.get("https://www.etsy.com/");
        etsySearchPage.signInButton.click();
        Assert.assertTrue(etsySearchPage.signInModal.isDisplayed());
        Assert.assertEquals(etsySearchPage.signInModalHeading.getText(),"Sign in to continue");
    }

    @Test(priority = 2,description = "test 2 - information Alert")
    public void validateInformationWarningAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");

        heroAppPage.clickOnAlertButton("Click for JS Alert");
        Waiter.pause(10);

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        AlertHandler.acceptAlert(driver);//click on OK

        Assert.assertEquals(heroAppPage.resultParagraph.getText(),"You successfully clicked an alert");
    }



    @Test(priority = 3,description = "Test-3- Confirmation alert")
    public void testConfirmationAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");
        heroAppPage.clickOnAlertButton("Click for JS Confirm");

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        AlertHandler.dismissAlert(driver);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(),"You clicked: Cancel");

        heroAppPage.clickOnAlertButton("Click for JS Confirm");
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        AlertHandler.acceptAlert(driver);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(),"You clicked: Ok");

    }

    /*
   Go to http://the-internet.herokuapp.com/
    Click on "JavaScript Alerts" link
    Click on "Click for JS Prompt" button
    Validate the text of the alert displayed is "I am a JS prompt"
    Click on "Cancel" button on the alert
    Validate "You entered: null" message is displayed with its text
    Click on "Click for JS Prompt" button again
    Type "Hello" in the alert input box
    Click on "OK" button on the alert
    Validate "You entered: Hello" message is displayed with its text

     */
    @Test(priority = 4,description = "Task-4-Promt Alert")
    public void testPromptAlert(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("JavaScript Alerts");

        heroAppPage.clickOnAlertButton("Click for JS Prompt");
        Assert.assertEquals(AlertHandler.getAlertSText(driver),"I am a JS prompt");
        AlertHandler.dismissAlert(driver);

        Assert.assertEquals(heroAppPage.resultParagraph.getText(),"You entered: null");
        heroAppPage.clickOnAlertButton("Click for JS Prompt");

        AlertHandler.sendKeysToAlert(driver,"Hello");
        Waiter.pause(2);
        AlertHandler.acceptAlert(driver);
        Assert.assertEquals(heroAppPage.resultParagraph.getText(),"You entered: Hello");

    }

     /*
    TASK-5 - Amazon Address Modal
    Go to https://www.amazon.com/
    Click on "Select your address" link in the top navigation bar
    Validate "Choose your location" modal is displayed
    Enter your zip code to input box
    Click on "Apply" button
    Validate the zip code entered displayed in the delivery message
     */

    @Test(priority = 5, description = "TASK-5 - Amazon Address Modal")
    public void testAmazonAddressModal(){
        driver.get("https://www.amazon.com/");
        amazonPage.selectYourAddressButton.click();
        Assert.assertTrue(amazonPage.chooseYourLocationModal.isDisplayed());
        amazonPage.zipCodeInput.sendKeys("60631"+ Keys.ENTER);
//        amazonPage.applyButton.click();
        Assert.assertEquals(amazonPage.deliveryMessage.getText(),"60631" );

    }
}
