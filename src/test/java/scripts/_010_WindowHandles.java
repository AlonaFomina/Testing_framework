package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _010_WindowHandles  extends Base{
    @Test(priority = 1,description = "TEAT CASE-1")
    public void techGlobalSchoolFaceBookIcon(){
        driver.get("https://www.techglobalschool.com/");

        System.out.println(driver.getWindowHandles());
        //[CDwindow-A0B668D92C70177EA0C9615B0F013525]  unique ID

        String tgWindowHandler = driver.getWindowHandle();
        Waiter.pause(3);

        System.out.println("-----Switching back to Facebook-----");
        tgHomePage.faceBooKIcon.click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(tgWindowHandler))driver.switchTo().window(windowHandle);
        }
        driver.getWindowHandles();

        Waiter.pause(3);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        System.out.println("-----Switching back to TechGlobal-----");
        driver.switchTo().window(tgWindowHandler);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
    /*
TEST CASE 2: Multiple Windows
Go to http://the-internet.herokuapp.com/
Click on "Multiple Windows" link
Click on "Click Here" link
Validate the heading3 as "New Window"
Navigate back to previous window
Validate the heading3 as "Opening a new window"

 */
    @Test(priority = 2,description = "TEST-@-Multiple Windows")
    public void testWindowHandle2(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Multiple Windows");

        String mainWindow = driver.getWindowHandle();

        heroAppPage.clickHereLink.click();

        for(String windowHandle: driver.getWindowHandles()){
            if(!windowHandle.equals(mainWindow)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(heroAppPage.newWindowH3.getText(), "New Window");
        driver.switchTo().window(mainWindow);
        Assert.assertEquals(heroAppPage.windowsH3.getText(), "Opening a new window");
    }
}
