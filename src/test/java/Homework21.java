import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String updatedPlaylistMessage = "Updated playlist \"Rename.\"";

        loginPage.logIn();
        doubleClickPlaylist();
        enterNewPlaylistName();
        //Assert
        Assert.assertEquals(renameSuccessMessage(), updatedPlaylistMessage);
    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(5)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInput.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playlistInput.sendKeys("Rename");
        playlistInput.sendKeys(Keys.ENTER);
    }

    public String renameSuccessMessage(){
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }
}
