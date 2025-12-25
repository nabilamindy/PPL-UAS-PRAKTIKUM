package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    // Locators
    private By productTitle = By.cssSelector(".name");
    private By productPrice = By.cssSelector(".price-container");
    private By addToCartButton = By.linkText("Add to cart");
    private By productDescription = By.id("more-information");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }

    public String getAlertMessage() {
        waitForAlert();
        return getAlertText();
    }

    public void acceptAlertMessage() {
        acceptAlert();
    }

    public boolean isProductDisplayed() {
        return isDisplayed(productTitle);
    }
}
