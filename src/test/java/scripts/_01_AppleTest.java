package scripts;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
public class _01_AppleTest extends Base{
    //just declaring
    // 1. Initial set up - before each test



    @Test(priority = 1)
    // 2. Validation of test - test
    public void testAppleTitle() {
        driver.get("https://www.apple.com/");
        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

       /*
       instead of if else we will use TestNG asserting
       if (actualTitle.equals(expectedTitle)) System.out.println("Apple title validation passed");
        else System.out.println("Apple title validation failed");

        */

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(priority = 2)
    public void testAppleURL(){
        driver.get("https://www.apple.com/");
        String expectedURL="https://www.apple.com/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(enabled = false,priority = 3)
    public void X(){
        Assert.fail("Failure on purpose");
    }
    /*
    public static void main(String[] args) {
        // 1. Initial set up - before each test
        WebDriver driver = Driver.getDriver();

        // 2. Validation of test - test
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

        if(actualTitle.equals(expectedTitle)) System.out.println("Apple title validation passed");
        else System.out.println("Apple title validation failed");

        // 3. Teardown actions - after each test
        Driver.quitDriver();
    }*/

}
