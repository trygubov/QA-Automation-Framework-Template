import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class BaseTest {

    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public String url = "https://qa.koel.app/";
    public Actions actions = null;


    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        actions = new Actions(driver);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    //LogIn
    public void logIn() {
        provideEmail("valeriya.trygubova@testpro.io");
        providePassword("ltZaqmXZ");
        clickSubmit();
    }

    //Email
    void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    //Password
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    //Submit
    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    //Click play next song
    public void playNextSong() {
        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextSong.click();
    }

    //Click Play
    public void clickPlay() {
        WebElement clickPlay = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        clickPlay.click();
    }
}