package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators

    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By submitButton = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElementUsingByLocator(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElementUsingByLocator(passwordField).sendKeys(password);
    }

    public void clickSubmit(){
        findElementUsingByLocator(submitButton).click();
    }

    public void logIn(){
        provideEmail("valeriya.trygubova@testpro.io");
        providePassword("ltZaqmXZ");
        clickSubmit();
    }
}
