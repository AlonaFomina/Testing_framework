package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _09_Iframes extends Base{

    /*
    Go to http://the-internet.herokuapp.com/
    2. Click on “Frames” link
    3. Click on “iFrame” link
    4. Clear text “Your content goes here.” in the content
    box
    5. Enter “Hello World” in the content box
    6. Validate the text of the content box is “Hello
    World”
    7. Validate the heading3 as “An iFrame containing the
    TinyMCE WYSIWYG Editor”
     */
    @Test(priority = 1)
    public void testIframe1() {
        driver.get("http://the-internet.herokuapp.com/");
       heroAppPage.clickOnLink("Frames");
       heroAppPage.iFrameLink.click();
       driver.switchTo().frame(0);
       heroAppPage.contentBox.clear();
       heroAppPage.contentBox.sendKeys("Hello World");
       Assert.assertEquals(heroAppPage.contentBox.getText(),"Hello World");
       driver.switchTo().parentFrame();
//       driver.switchTo().defaultContent();
       Assert.assertEquals(heroAppPage.iFrameHeading3.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");

    }

    @Test(priority = 2)
    public void testIframe2(){
        driver.get("https://www.rediff.com/");

        //System.out.println(rediffHomePage.moneyCells.size());

        driver.switchTo().frame(rediffHomePage.moneyIFrame);

        //System.out.println(rediffHomePage.moneyCells.size());

        for (WebElement element : rediffHomePage.moneyCells) {
            System.out.println(element.getText());
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
