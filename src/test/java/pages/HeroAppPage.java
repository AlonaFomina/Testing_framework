package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeroAppPage {
    public HeroAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul/li/a")
    public List<WebElement> homepageLinks;

    @FindBy(css = "#checkboxes>input")
    public List<WebElement> checkboxes;

    @FindBy(xpath = "//ul//button")
    public List<WebElement>alertButtons;

    @FindBy(id = "result")
    public WebElement resultParagraph;

    @FindBy(xpath = "//a[text()='iFrame']")
    public WebElement iFrameLink;

    @FindBy(css = "#tinymce>p")
    public WebElement contentBox;

    @FindBy(xpath = "//h3")
    public WebElement iFrameHeading3;

    @FindBy(css = "#content a")
    public WebElement clickHereLink;

    @FindBy(xpath = "//h3")
    public WebElement windowsH3;

    @FindBy(xpath = "//body//h3[.='New Window']")
    public WebElement newWindowH3;

    @FindBy(id = "file-upload")
    public WebElement choseFileInputBox;

    @FindBy(id = "file-submit")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//h3")
    public WebElement fileUploadedH3;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFileText;

    @FindBy(xpath = "//div[@id='content']//a[@href='download/AFKnopa.txt']")
    public WebElement AFKnopa;



    public void clickOnLink(String linkText) {
        for (WebElement link : homepageLinks) {
            if (link.getText().equals(linkText)) {
                link.click();
                break;
            }
        }
    }

    public void clickOnAlertButton(String buttonText){
        for(WebElement element: alertButtons){
            if(element.getText().equals(buttonText)){
                element.click();
                break;
            }
        }
    }

}