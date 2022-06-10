package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {
    public GoogleSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    //Locate all Etsy Search Page web elements here
   @FindBy(id = "result-stats")
    public WebElement result;
}
