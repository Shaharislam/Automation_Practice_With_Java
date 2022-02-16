package mystore.automation.testcases;

import mystore.automation.helpers.DriverHelper;
import mystore.automation.webpages.HomePage;
import mystore.automation.webpages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationCheckoutTest extends DriverHelper {
    HomePage homePage = new HomePage();
    LoginPage login = new LoginPage();
    String email = homePage.emailAddress;
    String password = homePage.passwordText;

    @Test(priority = 1, description = "Create new Account")
    public void registrationTest() {
        homePage.clickLoginButton();
        homePage.setEmailAddress();
        homePage.clickSubmitButton();
        homePage.fillPersonalInformation();
        homePage.clickSubmitAccount();
        Assert.assertTrue(homePage.getUserName());
        Assert.assertEquals(driver.getTitle(), "My account - My Store");
        homePage.clickSignOutBtn();
        System.out.println(email);
        System.out.println(password);
    }

    @Test(priority = 2, description = "Login new account and purchase product")
    public void logInAccountTest() {
        login.clickSignInBtn();
        login.fillUserCredential("pablo.roob@hotmail.com", "password@123456");
        login.clickSubmitBtn();
        login.clickCausalDress();
        login.addToCartAndProceedCheckout();
        Assert.assertEquals(login.successMessageDisplayed(), "Your order on My Store is complete.");
        login.clickSignOutBtn();
        Assert.assertEquals(driver.getTitle(), "Login - My Store");

    }

}
