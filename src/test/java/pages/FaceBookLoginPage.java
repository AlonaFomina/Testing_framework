package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FaceBookLoginPage {
    public FaceBookLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[id^='u_0_2_']")
    public WebElement createNewAccountLink;

//sing in form
    @FindBy(xpath = "//span[@data-type='radio']//span")
    public List<WebElement> genderRadioButtons;

    @FindBy(xpath = "//input[@aria-required='true']")
    public List<WebElement> inputInfo;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstNameInputBox;

    @FindBy(css = "input[name='lastname'")
    public WebElement lastNameInputBox;

    @FindBy(css = "input[name='reg_email__']")
    public WebElement emailOrPhoneInputBox;

    @FindBy(css = "input[name='reg_email_confirmation__']")
    public WebElement emailReEnterInputBox;

    @FindBy(css = "input[name='reg_passwd__']")
    public WebElement passwordInputBox;

    @FindBy(id = "month")
    public WebElement monthDropDown;

    @FindBy(id = "day")
    public WebElement dayDropDown;

    @FindBy(id = "year")
    public WebElement yearDropDown;

    @FindBy(css = "._1lch > button")
    public WebElement singIn;

    @FindBy(css = "._8ien")
    public WebElement loginMenu;

    @FindBy(id = "reg_error_inner")
    public WebElement errorMessage;

    //@FindBy(css = "._8esa")
    //public List<WebElement> genderRadioButtons;


}
