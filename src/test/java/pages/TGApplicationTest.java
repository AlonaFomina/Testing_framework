package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TGApplicationTest {
    public TGApplicationTest(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    //Locate all Etsy Search Page web elements here
    @FindBy(xpath ="//h1[@class='font_6']")
    public WebElement header1;

}
