package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {
    Actions actions;
    WebDriver driver;
    WebDriverWait explicitWait;
    Wait fluentWait;
    EtsySearchPage etsySearchPage;
    TGApplicationTest tgApplicationPage;
    GoogleSearchPage googleSearchPage;
    GoogleSearchResultPage googleSearchResultPage;
    FaceBookLoginPage faceBookLoginPage;
    HeroAppPage heroAppPage;
    ExpediaSearchPage expediaSearchPage;
    EbayPage ebayPage;
    SoftAssert softAssert;
    AmazonPage amazonPage;
    RediffHomePage rediffHomePage;
    TGHomePage tgHomePage;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(Exception.class);
        etsySearchPage = new EtsySearchPage(driver);
        tgApplicationPage = new TGApplicationTest(driver);
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        faceBookLoginPage = new FaceBookLoginPage(driver);
        heroAppPage = new HeroAppPage(driver);
        expediaSearchPage = new ExpediaSearchPage(driver);
        ebayPage = new EbayPage(driver);
        softAssert = new SoftAssert();
        amazonPage = new AmazonPage(driver);
        rediffHomePage = new RediffHomePage(driver);
        tgHomePage = new TGHomePage(driver);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
        softAssert.assertAll();
    }
}