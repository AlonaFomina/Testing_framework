package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _04GoogleSearchTest extends Base {
    @Test(priority = 1)
    public void testGoogleSearch() {
        driver.get("https://www.google.com/");

        googleSearchPage.searchInputBox.sendKeys("Selenium" + Keys.ENTER);

        String resultstatus = googleSearchResultPage.result.getText();

        Assert.assertTrue(Long.parseLong(resultstatus.substring(resultstatus.indexOf(" ") + 1, resultstatus.indexOf("results") - 1).replace(",", "")) > 0);

    }

    @Test(priority = 2, description = "TC123: Validate Google Store link")
    public void testGoogleStoreLink() {
        driver.get("https://www.google.com/");

        //explicitWait.until(ExpectedConditions.visibilityOf(googleSearchPage.storeLink)); // 120 attempts
        Waiter.waitForVisibilityOfElement(driver, googleSearchPage.storeLink, 30);
        googleSearchPage.storeLink.click();//

        //Throws exception - Use explicit wait to prevent
        //explicitWait.until(ExpectedConditions.titleIs("Google Store for Google Made Devices & Accessories"));
        Waiter.waitUntilTitleIs(driver, 30, "Google Store for Google Made Devices & Accessories");

        Assert.assertEquals(driver.getTitle(), "Google Store for Google Made Devices & Accessories");
    }
}