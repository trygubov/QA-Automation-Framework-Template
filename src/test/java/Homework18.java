import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest {
 @Test
    public void playSong(){

     BasePage basePage = new BasePage(driver);
     LoginPage loginPage = new LoginPage(driver);
     HomePage homePage = new HomePage(driver);

     loginPage.logIn();
     BasePage.playNextSong();
     BasePage.clickPlay();

     //Assert
     Assert.assertTrue(basePage.isSongPlaying());

 }

}
