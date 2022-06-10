package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class McLocationPage {
    public McLocationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='cmp-restaurant-locator__restaurant-list'])/ol/li")
    public List<WebElement> restaurantList;

    @FindBy(xpath = "//input[@data-cmp-hook-form-text='input']")
    public WebElement zipInput;

    @FindBy(xpath = "//span[@class='cmp-restaurant-locator__restaurant-list-item-index']")
    public List<WebElement>numberOfRest;

    @FindBy(xpath = "//li[@class='cmp-restaurant-locator__restaurant-list-item']//a")
    public List<WebElement>getRestaurantList;

    @FindBy(xpath = "//button[@aria-controls='mcdFilterMenu']")
    public WebElement filterButton;

    @FindBy(xpath = "//li[@class='cmp-form-options__field-label']/label")
    public List<WebElement> servicesCheckBoxes;

    @FindBy(xpath = "//li[@class='cmp-form-options__field-label']")
    public List<WebElement> servicesCheck;


    @FindBy(xpath = "//button[@type='reset']")
    public WebElement resetButton;

    @FindBy(xpath = "//input[@class='cmp-form-options__field cmp-form-options__field--radio']")
    public List<WebElement> radioButton;
}
