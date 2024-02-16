package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Element Locators

    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement submitButton;

    //Methods

    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        submitButton.click();
        return this;
    }

    public void logIn(){
        provideEmail("valeriya.trygubova@testpro.io");
        providePassword("ltZaqmXZ");
        clickSubmit();
    }
}
