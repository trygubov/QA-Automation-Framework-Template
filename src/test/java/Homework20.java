import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        logIn();

        //Click on playlist
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
        playlist.click();


        //Click delete
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();

        //Assert
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Test.\"";
        Assert.assertEquals(getDeletedPlaylistMessage(),expectedPlaylistDeletedMessage);

    }

    public String getDeletedPlaylistMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }
}
