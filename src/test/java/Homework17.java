import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {


        provideEmail("valeriya.trygubova@testpro.io");
        providePassword("ltZaqmXZ");
        clickSubmit();

        //Search
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=search]")));
        searchField.clear();
        searchField.sendKeys("pluto");

        //View All
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAll.click();

        //Select First Song
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper table.items tr:first-child")));
        firstSongInTheList.click();

        //Add
        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn-add-to']")));
        addToButton.click();

        //Select
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), 'Bops')]")));
        playlist.click();

        //Assert
        WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        Assert.assertTrue(warningMessage.isDisplayed());
        Thread.sleep(2000);
        Assert.assertEquals("Added 1 song into \"Bops.\"", warningMessage.getText());
        System.out.println("Warning message: " + warningMessage.getText());

        driver.quit();

    }
}