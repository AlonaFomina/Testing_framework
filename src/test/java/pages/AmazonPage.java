package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
    public AmazonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='glow-ingress-block']")
    public WebElement selectYourAddressButton;

    @FindBy(className ="a-popover-wrapper")
    public WebElement chooseYourLocationModal;

    @FindBy(xpath = "(//input[@class='a-button-input'])[3]")
    public WebElement applyButton;

    @FindBy(id = "GLUXZipConfirmationValue")
    public WebElement deliveryMessage;

    @FindBy (id = "GLUXZipUpdateInput")
    public WebElement zipCodeInput;
}
