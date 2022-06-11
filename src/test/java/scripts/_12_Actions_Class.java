package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.List;

public class _12_Actions_Class extends Base{
    @Test(priority = 1,description = "Actions | move to element 1")
    public void moveToElementPractice1(){
        driver.get("https://www.techglobalschool.com/");
        WebElement address = driver.findElement(By.cssSelector("#comp-kixny3ro span>span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(address).build().perform();
        Waiter.pause(3);

        Assert.assertEquals(address.getText(),"2860 S River Rd Suite 350, Des Plaines IL 60018");
    }


    @Test(priority = 2,description = "Actions | move to element 2")
    public void moveToElementPractice2() {
        driver.get("https://www.carvana.com/");
        //Waiter.waitForVisibilityOfElement(driver,driver.findElement(By.xpath("//span[@class='HeaderFinancingstyles__MenuTitle-sc-3g0y8k-3 kAQuLc']"),60));
        driver.navigate().refresh();
        List<WebElement> financeDropDownOptions = driver.findElements(By.cssSelector("a[data-cv-test^='headerFinance']"));
        WebElement financeDropDown = driver.findElement(By.xpath("//span[@class='HeaderFinancingstyles__MenuTitle-sc-3g0y8k-3 kAQuLc']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(financeDropDown).build().perform();
        Waiter.pause(3);

        String[] expectedFinanceDropMenu = {"WHY FINANCE WITH CARVANA",
                "GET PREQUALIFIED",
                "AUTO LOAN CALCULATOR"};

        for (int i = 0; i < expectedFinanceDropMenu.length; i++) {
            Assert.assertEquals(financeDropDownOptions.get(i).getText(), expectedFinanceDropMenu[i]);

        }
    }

    @Test(priority = 3,description = "Clicking")
    public void clickOnRegisterForIntroButton(){
        driver.get("https://www.techglobalschool.com/");

        WebElement registerForIntroButton  = driver.findElement(By.xpath("//div[@id='comp-kvjohd5t5']/a"));
        Actions actions = new Actions(driver);

        actions.moveToElement(registerForIntroButton).build().perform();
        Waiter.pause(3);
        actions.click(registerForIntroButton).build().perform();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.techglobalschool.com/apply-now-1");

    }
}
