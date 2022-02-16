package mystore.automation.testcases;

import mystore.automation.helpers.DriverHelper;
import mystore.automation.webpages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationCheckoutTest extends DriverHelper {
    HomePage homePage = new HomePage();
    String email = homePage.emailAddress;
    String password = homePage.passwordText;

    @Test(priority = 1)
    public void registrationTest() {
        homePage.clickLoginButton();
        homePage.setEmailAddress();
        homePage.clickSubmitButton();
        homePage.fillPersonalInformation();
        homePage.clickSubmitAccount();
        Assert.assertTrue(homePage.getUserName());
        Assert.assertEquals(driver.getTitle(), "My account - My Store");
    }

    @Test(priority = 2)
    public void addProductCartTest() {
        System.out.println(email);
        System.out.println(password);
    }
}
