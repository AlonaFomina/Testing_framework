package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.List;

public class _13_Tables_Test extends Base{
    @Test(priority = 1, description = "Tables Headers")
    public void testTablesHeaders() {
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");


        String[] expectedText = {"Last Name", "First Name", "Email", "Due", "Web Site", "Action"};
        for (int i = 0; i < 6; i++) {
            Waiter.waitUntilTextToBePresentInElement(driver, 10, heroAppPage.headings.get(i), expectedText[i]);
            Assert.assertEquals(heroAppPage.headings.get(i).getText(), expectedText[i]);
        }


    }
    @Test(priority = 2,description = "Table | first row")
    public void testFirstRow() {

        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> header1List = driver.findElements(By.cssSelector("#table1>tbody>tr:nth-child(1)>td"));
        String[] expectedHeader1List1 = {"Smith",
                "John",
                "jsmith@gmail.com",
                "$50.00",
                "http://www.jsmith.com",
                "edit delete"};

        for (int i = 0; i < expectedHeader1List1.length; i++) {
            Waiter.waitUntilTextToBePresentInElement(driver, 10, header1List.get(i), expectedHeader1List1[i]);
            Assert.assertEquals(header1List.get(i).getText(), expectedHeader1List1[i]);
        }
    }
    @Test(priority = 3,description = "Test | First Name")
    public void testTable1FirstName(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        List<WebElement> firstNameList = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        String[] expectedFirstNameList ={"John",
                "Frank",
                "Jason",
                "Tim"};
        for (int i = 0; i <expectedFirstNameList.length ; i++) {
            Waiter.waitForUntilTextToBEPresentInElement(driver,10,firstNameList.get(i),expectedFirstNameList[i]);
            Assert.assertEquals(firstNameList.get(i).getText(), expectedFirstNameList[i]);
        }
    }
    @Test(priority = 4,description = "Test | All Cells")
    public void validateAlCellsNotEmpty(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");
        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1 td"));
        System.out.println(allCells.size());

        for (WebElement allCell : allCells) {
            Assert.assertNotEquals(allCell.getText(),"");
        }
    }
}
