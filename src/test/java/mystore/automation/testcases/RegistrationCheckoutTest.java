package mystore.automation.testcases;

import com.github.javafaker.Faker;
import mystore.automation.helpers.DriverHelper;
import mystore.automation.webpages.HomePage;
import mystore.automation.webpages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationCheckoutTest extends DriverHelper {
    String emailFirstUser = new Faker().internet().emailAddress();
    String emailSecondUser = new Faker().internet().emailAddress();
    String passwordFirstUser = "pass@123456";
    String passwordSecondUser = "pass@654321";

    HomePage homePage = new HomePage();
    LoginPage login = new LoginPage();

    @DataProvider(name = "register-data")
    public Object[][] userData() {
        return new Object[][]{{emailFirstUser, passwordFirstUser}, {emailSecondUser, passwordSecondUser}};
    }

    @Test(priority = 1, description = "Create new Account", dataProvider = "register-data")
    public void registrationTest(String email, String password) {
        homePage.clickLoginButton();
        homePage.setEmailAddress(email);
        homePage.clickSubmitButton();
        homePage.fillPersonalInformation(password);
        homePage.clickSubmitAccount();
        Assert.assertTrue(homePage.getUserName());
        Assert.assertEquals(driver.getTitle(), "My account - My Store");
        homePage.clickSignOutBtn();
    }

    @Test(priority = 2, description = "Login new account with first user and purchase product")
    public void purchaseProductWithFirstUser() {
        login.clickSignInBtn();
        login.fillUserCredential(emailFirstUser, passwordFirstUser);
        login.clickSubmitBtn();
        login.clickCausalDress();
        login.addToCartAndProceedCheckout();
        Assert.assertEquals(login.successMessageDisplayed(), "Your order on My Store is complete.");
        login.clickSignOutBtn();
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }

    @Test(priority = 3, description = "Login new account second user and purchase product")
    public void purchaseProductWithSecondUser() {
        login.clickSignInBtn();
        login.fillUserCredential(emailSecondUser, passwordSecondUser);
        login.clickSubmitBtn();
        login.clickCausalDress();
        login.addToCartAndProceedCheckout();
        Assert.assertEquals(login.successMessageDisplayed(), "Your order on My Store is complete.");
        login.clickSignOutBtn();
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }
}
