package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {
    // Locators
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpButton = By.xpath("//button[text()='Sign up']");
    private By closeButton = By.xpath("//div[@id='signInModal']//button[text()='Close']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickSignUpButton() {
        click(signUpButton);
    }

    public String getAlertMessage() {
        waitForAlert();
        return getAlertText();
    }

    public void acceptAlertMessage() {
        acceptAlert();
    }

    public void performSignUp(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignUpButton();
    }
}
