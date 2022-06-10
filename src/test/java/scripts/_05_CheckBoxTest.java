package scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _05_CheckBoxTest extends Base{
/*
    Go to http://the-internet.herokuapp.com/
    Click on "Checkboxes" link
    Validate "checkbox 1" is displayed, enabled and not selected
    Validate "checkbox 2" is displayed, enabled and selected
    Select "checkbox 1" and validate it is selected
    Deselect both "checkbox 1" and "checkbox 2" and validate they are deselected
     */

    @Test(priority = 1, description = "TC001: Validate checkbox in hero app")
    public void testCheckBoxInHeroApp(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Checkboxes");

        //Validate both checkboxes are displayed and enabled
        for(WebElement element: heroAppPage.checkboxes){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
        }

        //Validate checkbox 1 is not selected and checkbox 2 is selected
        Assert.assertFalse(heroAppPage.checkboxes.get(0).isSelected());
        Assert.assertTrue(heroAppPage.checkboxes.get(1).isSelected());

//        Waiter.pause(2);

        // Select "checkbox 1" and validate it is selected
        explicitWait.until(ExpectedConditions.elementToBeClickable(heroAppPage.checkboxes.get(0)));
        heroAppPage.checkboxes.get(0).click();

        explicitWait.until(ExpectedConditions.elementToBeSelected(heroAppPage.checkboxes.get(0)));
        Assert.assertTrue(heroAppPage.checkboxes.get(0).isSelected());

        // Deselect both "checkbox 1" and "checkbox 2" and validate they are deselected
        for (WebElement element: heroAppPage.checkboxes) {
//            Waiter.pause(2);
            explicitWait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            explicitWait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
            Assert.assertFalse(element.isSelected());
        }
    }
}