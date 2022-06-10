package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class McHomePage {
    public McHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
//span[@class='icon icon-location')[1]
    @FindBy(linkText = "Change your Location")
    public WebElement changeLocationLink;
}
