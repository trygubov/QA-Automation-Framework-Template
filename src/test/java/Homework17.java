import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        // Manage Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        navigateToPage();
        provideEmail("valeriya.trygubova@testpro.io");
        providePassword("ltZaqmXZ");
        clickSubmit();

        //Search
        WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
        searchField.clear();
        searchField.sendKeys("For the Poor");

        //View All
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();

        //Select First Song
        WebElement firstSongInTheList = driver.findElement(By.cssSelector("section#songResultsWrapper table.items tr:first-child"));
        firstSongInTheList.click();

        //Add
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();

        //Select
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), 'Bops')]"));
        playlist.click();

        Thread.sleep(2000);

        //Assert
        WebElement warningMessage = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals("Added 1 song into 'Bops'", warningMessage.getText());
        System.out.println("Warning message: " + warningMessage.getText());

        Thread.sleep(2000);

        driver.quit();

    }
}