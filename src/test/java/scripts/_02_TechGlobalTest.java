package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_TechGlobalTest extends Base {

    @Test(description = "TC123:Validate Application form Heading",priority = 1)
    public void testAplicationFormHeading(){
        driver.get("https://www.techglobalschool.com/apply-now");
        //WebElement heading1 = tgApplicationTest.header1;

        Assert.assertTrue(tgApplicationPage.header1.isDisplayed());
        Assert.assertEquals(tgApplicationPage.header1.getText(), "Application Form");

    }

}
