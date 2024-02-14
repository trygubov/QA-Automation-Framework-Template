package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators

    By userAvatarIcon = By.cssSelector("[class='avatar']");

    //Methods

    public WebElement getUserAvatarIcon(){
        return findElementUsingByLocator(userAvatarIcon);
    }

}
