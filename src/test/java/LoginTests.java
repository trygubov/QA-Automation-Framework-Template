import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void logInWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("valeriya.trygubova@testpro.io");
        loginPage.providePassword("ltZaqmXZ");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}
