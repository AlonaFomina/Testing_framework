package selenium_White_Board;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class SeleniumWB {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        WebElement searchInputBox = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchInputBox.isDisplayed() && searchInputBox.isEnabled());

        String textToSearch = "bags";
        searchInputBox.sendKeys(textToSearch);


        WebElement inputBoxKey= driver.findElement(By.id("issprefix"));
        String searchValue = inputBoxKey.getAttribute("value");
        Assert.assertEquals(searchValue.substring(0, searchValue.indexOf(",")), textToSearch);

        searchInputBox.sendKeys(Keys.ENTER);


        String validTitle = "Amazon.com : " + textToSearch;
        Assert.assertEquals(driver.getTitle(),validTitle);

        WebElement result = driver.findElement(By.xpath("(//span[@class='a-size-medium-plus a-color-base a-text-normal'])[1]"));
        String expectedText = "RESULTS";

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),expectedText);






        driver.quit();
    }
}
