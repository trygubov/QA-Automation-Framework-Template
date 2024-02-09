import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {
@Test
    public void deletePlaylist(){

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    loginPage.logIn();

    //Click on playlist
    WebElement playlist =  driver.findElement(By.cssSelector(".playlist:nth-child(6)"));
    playlist.click();

    //Click delete
    WebElement deletePlaylist = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
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
