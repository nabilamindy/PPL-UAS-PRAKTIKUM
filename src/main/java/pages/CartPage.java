package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {
    // Locators
    private By cartItems = By.cssSelector(".success");
    private By totalPrice = By.id("totalp");
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By deleteButtons = By.linkText("Delete");

    // Place Order Modal
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");
    private By confirmationMessage = By.cssSelector(".sweet-alert h2");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public String getTotalPrice() {
        return getText(totalPrice);
    }

    public void clickPlaceOrder() {
        click(placeOrderButton);
    }

    public void deleteFirstItem() {
        click(deleteButtons);
    }

    public void fillOrderForm(String name, String country, String city,
                              String card, String month, String year) {
        type(nameField, name);
        type(countryField, country);
        type(cityField, city);
        type(cardField, card);
        type(monthField, month);
        type(yearField, year);
    }

    public void clickPurchase() {
        click(purchaseButton);
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }
}
