package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    Actions actions;

    public WebElement findElementUsingByLocator(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //Locators

    By playNextButton = By.xpath("//i[@data-testid='play-next-btn']");

    By clickPlay = By.xpath("//span[@data-testid='play-btn']");

    //Methods


    public void playNextSong() {
        WebElement playNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextSong.click();
    }

    public void clickPlay() {
        WebElement clickPlay = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        clickPlay.click();
    }

    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
