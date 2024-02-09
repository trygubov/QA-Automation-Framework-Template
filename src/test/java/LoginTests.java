import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Test
    public void loginEmptyEmailPassword() {

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void logInWithCorrectCredentials(){

        loginPage.provideEmail("valeriya.trygubova@testpro.io");
        loginPage.providePassword("ltZaqmXZ");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}
