package mystore.automation.webpages;

import mystore.automation.helpers.DriverHelper;
import org.openqa.selenium.By;

public class LoginPage extends DriverHelper {
    By signInBtn = By.className("login");
    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By submitBtn = By.id("SubmitLogin");
    By signOutBtn = By.xpath("//a[@title='Log me out']");
    By successMessage = By.xpath("//p[@class='alert alert-success']");


    public String successMessageDisplayed() {
        return driver.findElement(successMessage).getText();
    }

    public void clickSignOutBtn() {
        driver.findElement(signOutBtn).click();
    }

    public void clickSignInBtn() {
        driver.findElement(signInBtn).click();
    }

    void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    void setPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitBtn).click();
    }

    public void fillUserCredential(String email, String pass) {
        setEmail(email);
        setPassword(pass);
    }
}
