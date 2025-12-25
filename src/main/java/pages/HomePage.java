package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    // Locators
    private By signUpLink = By.id("signin2");
    private By loginLink = By.id("login2");
    private By logoutLink = By.id("logout2");
    private By welcomeUser = By.id("nameofuser");
    private By phonesCategory = By.linkText("Phones");
    private By laptopsCategory = By.linkText("Laptops");
    private By monitorsCategory = By.linkText("Monitors");
    private By cartLink = By.id("cartur");
    private By productLinks = By.cssSelector(".card-title a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignUp() {
        click(signUpLink);
    }

    public void clickLogin() {
        click(loginLink);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public boolean isLoggedIn() {
        return isDisplayed(welcomeUser);
    }

    public String getWelcomeText() {
        return getText(welcomeUser);
    }

    public void clickCategory(String category) {
        switch (category.toLowerCase()) {
            case "phones":
                click(phonesCategory);
                break;
            case "laptops":
                click(laptopsCategory);
                break;
            case "monitors":
                click(monitorsCategory);
                break;
        }
    }

    public void clickProduct(String productName) {
        click(By.linkText(productName));
    }

    public void goToCart() {
        click(cartLink);
    }

    public int getProductCount() {
        return driver.findElements(productLinks).size();
    }
}
