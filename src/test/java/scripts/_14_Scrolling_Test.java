package scripts;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _14_Scrolling_Test extends Base{
    @Test(priority = 1)
    public void testScroll(){
        driver.get("https://www.techglobalschool.com/");
       /* Waiter.pause(3);
       // actions.moveToElement(tgHomePage.registerForIntroLink).click().perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Waiter.pause(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Waiter.pause(3);*/
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'})", tgHomePage.registerForIntroLink);

        Waiter.pause(10);
    }
}
