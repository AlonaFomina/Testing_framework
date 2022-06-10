package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _11_FileUpload_Test extends Base{
    @Test(priority = 1,description = "Test-1-file apload")
    public void testFileUpload1() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Upload");
        Waiter.pause(3);
        heroAppPage.choseFileInputBox.sendKeys("/Users/alonafomina/IdeaProjects/testing_framework/AFKnopa.txt");
        Waiter.pause(3);
        heroAppPage.uploadFileButton.click();
        Waiter.pause(3);
        heroAppPage.AFKnopa.click();

        //

        Assert.assertEquals(heroAppPage.fileUploadedH3.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "AFKnopa.txt");
    }

    @Test(priority = 2,description = "Test-2- file downloads")
    public void testFileDownloads(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("File Download");

        Waiter.pause(3);

    }
}
