package tests;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://www.demoblaze.com/";

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initializeDriver(browser);
        driver.get(baseUrl);
        System.out.println("=== Test Started ===");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("=== Test Completed ===\n");
        }
    }
}

