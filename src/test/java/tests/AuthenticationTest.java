package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class AuthenticationTest extends BaseTest {

    @Test(priority = 1, description = "TC-AUTH-001: Verify successful sign up")
    public void testSignUpSuccessful() {
        System.out.println("Running: TC-AUTH-001 - Sign Up Test");

        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        // Generate unique username
        String username = "testuser" + System.currentTimeMillis();
        String password = "Test123!";

        homePage.clickSignUp();
        signUpPage.performSignUp(username, password);

        String alertMessage = signUpPage.getAlertMessage();
        System.out.println("Alert Message: " + alertMessage);

        Assert.assertEquals(alertMessage, "Sign up successful.",
                "Sign up should be successful");

        signUpPage.acceptAlertMessage();
        System.out.println("✅ TC-AUTH-001 PASSED");
    }

    @Test(priority = 2, description = "TC-AUTH-002: Verify successful login")
    public void testLoginSuccessful() {
        System.out.println("Running: TC-AUTH-002 - Login Test");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Using pre-registered account
        String username = "user_nabila";
        String password = "pass123";

        homePage.clickLogin();
        loginPage.performLogin(username, password);

        // Wait and verify login
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(homePage.isLoggedIn(),
                "User should be logged in");

        String welcomeText = homePage.getWelcomeText();
        System.out.println("Welcome Text: " + welcomeText);
        Assert.assertTrue(welcomeText.contains(username),
                "Welcome message should contain username");

        System.out.println("✅ TC-AUTH-002 PASSED");
    }
}
