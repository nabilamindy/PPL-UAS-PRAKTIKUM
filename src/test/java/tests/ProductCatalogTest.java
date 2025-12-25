package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;

public class ProductCatalogTest extends BaseTest {

    @Test(priority = 1, description = "TC-PROD-001: Verify product filtering by category")
    public void testProductCategoryFilter() {
        System.out.println("Running: TC-PROD-001 - Category Filter Test");

        HomePage homePage = new HomePage(driver);

        // Test Phones category
        homePage.clickCategory("Phones");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int phoneCount = homePage.getProductCount();
        System.out.println("Phones displayed: " + phoneCount);
        Assert.assertTrue(phoneCount > 0, "Phones should be displayed");

        // Test Laptops category
        homePage.clickCategory("Laptops");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int laptopCount = homePage.getProductCount();
        System.out.println("Laptops displayed: " + laptopCount);
        Assert.assertTrue(laptopCount > 0, "Laptops should be displayed");

        System.out.println("✅ TC-PROD-001 PASSED");
    }

    @Test(priority = 2, description = "TC-PROD-002: Verify product detail page")
    public void testProductDetailView() {
        System.out.println("Running: TC-PROD-002 - Product Detail Test");

        HomePage homePage = new HomePage(driver);
        ProductDetailPage productPage = new ProductDetailPage(driver);

        // Click on first product (Samsung galaxy s6)
        homePage.clickProduct("Samsung galaxy s6");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(productPage.isProductDisplayed(),
                "Product should be displayed");

        String title = productPage.getProductTitle();
        String price = productPage.getProductPrice();

        System.out.println("Product: " + title);
        System.out.println("Price: " + price);

        Assert.assertFalse(title.isEmpty(), "Product title should not be empty");
        Assert.assertFalse(price.isEmpty(), "Product price should not be empty");

        System.out.println("✅ TC-PROD-002 PASSED");
    }
}

