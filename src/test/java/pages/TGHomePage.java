package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TGHomePage {
    public TGHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#img_0_comp-kixnxkbc")
    public WebElement faceBooKIcon;

    @FindBy(css = "#comp-kvjohd5t5>a")
    public WebElement registerForIntroLink;
}
