package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    }

    //Locators

    By submitButton = By.cssSelector("button[type='submit']");

    By playNextButton = By.xpath("//i[@data-testid='play-next-btn']");

    By clickPlay = By.xpath("//span[@data-testid='play-btn']");

    //Methods

    public void clickSubmit(){
        findElementUsingByLocator(submitButton).click();
    }

    //Click play next song
    public void playNextSong() {
        findElementUsingByLocator(playNextButton).click();
    }

    //Click Play
    public void clickPlay() {
        findElementUsingByLocator(clickPlay).click();
    }
}
