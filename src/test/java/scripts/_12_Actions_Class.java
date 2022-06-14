package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.security.Key;
import java.time.Duration;
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

        actions.moveToElement(registerForIntroButton).build().perform();
        Waiter.pause(3);
        actions.click(registerForIntroButton).perform();


        Assert.assertEquals(driver.getCurrentUrl(),"https://www.techglobalschool.com/apply-now-1");
    }
    @Test (priority = 4,description = "Action | Right click")
    public void rightClickAction(){
        driver.get("https://www.techglobalschool.com/");

        WebElement registerForIntroButton  = driver.findElement(By.xpath("//div[@id='comp-kvjohd5t5']/a"));
        Actions actions = new Actions(driver);
        actions.contextClick(registerForIntroButton).perform();//right click
        Waiter.pause(3);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.techglobalschool.com/");

    }
    @Test(priority = 5,description = "Action | Click and Hold")
        public void clickHoldAndReleasePractice(){
            driver.get("https://demoqa.com/droppable");

            WebElement dragMeBox = driver.findElement(By.id("draggable"));
            WebElement dropHereBox = driver.findElement(By.id("droppable"));

            //actions.clickAndHold(dragMeBox).moveToElement(dropHereBox).release().perform();
            actions.dragAndDrop(dragMeBox, dropHereBox).perform();

            Assert.assertEquals(dropHereBox.getText(), "Dropped!");
    }

    @Test(priority = 6, description = "Actions | Send Keys to element")
    public void sendKeysToAnElement(){
        driver.get("https://www.google.com/");
       actions.sendKeys(googleSearchPage.searchInputBox, "Hello").perform();

       Assert.assertEquals(googleSearchPage.searchInputBox.getAttribute("value"),"Hello");

    }

    @Test(priority = 7,description = "Actions | key down and Key up")
    public void practiceKeyDownAndKeyUp(){
        driver.get("https://www.google.com/");

        //googleSearchPage.searchInputBox.sendKeys("TECHGLOBALTECHGLOBAL");

        actions.keyDown(Keys.SHIFT)
                .sendKeys(googleSearchPage.searchInputBox, "techglobal")
                .keyUp(Keys.SHIFT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .pause(Duration.ofSeconds(2))
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .pause(Duration.ofSeconds(2))
                .keyDown(Keys.COMMAND).sendKeys("v")
                .perform();

        Waiter.pause(2);
    }

    @Test(priority = 8, description = "Etsy | test - Validate list of the categories")
    public void etsyTest(){
        driver.get("https://www.etsy.com/");

        actions.moveToElement(etsySearchPage.mainHeaderLinks.get(1)).build().perform();

        String[] expectedListOfAccessories = {"Accessories" ,
                "Bags & Purses" ,
                "Necklaces" ,
                "Rings" ,
                "Earrings" ,
                "Bracelets" ,
                "Body Jewelry" ,
                "All Jewelry"};


        for (int i = 0; i < expectedListOfAccessories.length; i++) {
            Waiter.waitForUntilTextToBEPresentInElement(driver,10,etsySearchPage.jewelryAndAccessoriesItems.get(i),expectedListOfAccessories[i]);
            Assert.assertEquals(etsySearchPage.jewelryAndAccessoriesItems.get(i).getText(),expectedListOfAccessories[i]);

        }

    }
}
