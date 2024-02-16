package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators

    @FindBy(css="[class='avatar']")
    WebElement userAvatarIcon;

    @FindBy (css="[title='Play next song']")
    WebElement playNextButton;

    @FindBy (css="[class = 'play']")
    WebElement playButton;

    //Methods

    public WebElement getUserAvatarIcon(){
        return wait .until(ExpectedConditions.visibilityOf(userAvatarIcon));
    }

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

