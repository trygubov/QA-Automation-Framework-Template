import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
@Test
    public void deletePlaylist() throws InterruptedException {

    logIn();
    Thread.sleep(2000);

    //Click on playlist
    WebElement playlist =  driver.findElement(By.cssSelector(".playlist:nth-child(6)"));
    playlist.click();
    Thread.sleep(2000);

    //Click delete
    WebElement deletePlaylist = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
    deletePlaylist.click();
    Thread.sleep(2000);

    //Assert
    String expectedPlaylistDeletedMessage = "Deleted playlist \"Test.\"";
    Assert.assertEquals(getDeletedPlaylistMessage(),expectedPlaylistDeletedMessage);

}

    public String getDeletedPlaylistMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }
}
