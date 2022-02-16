package mystore.automation.webpages;

import mystore.automation.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverHelper {

    By signInBtn = By.className("login");
    By emailField = By.id("email");
    By passwordField = By.id("passwd");
    By submitBtn = By.id("SubmitLogin");
    By casualDressPath= By.xpath("//a[@title='Casual Dresses']");
    By casualDressclinkText= By.partialLinkText("CASUAL DRESSES");
    By dressLinkText= By.linkText("DRESSES");
    By dressPath= By.linkText("//a[@title='Dresses']");
    By imageHober= By.xpath("//div[@class='product-image-container']");
    By addToCartClick= By.xpath("//a[@title='Add to cart']");
    By processToCheckOut= By.xpath("//a[@title='Proceed to checkout']");
    By processedToCheckOut= By.xpath("//span[text()='Proceed to checkout']");
    By termsAndService= By.id("//input[@id='cgv']");
    By proceedToCheckout= By.xpath("//button[@type='submit']");
    By paymentCheck= By.xpath("//a[@title='Pay by check.']");
    By orderConfirm= By.xpath("//span[text()='I confirm my order']");
    By signOutBtn = By.xpath("//a[@title='Log me out']");


    public void addToCart(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(imageHober)).build().perform();
        driver.findElement(addToCartClick).click();
        driver.findElements(processToCheckOut).get(0).click();
        scrollDown();
        driver.findElements(processToCheckOut).get(1).click();
        driver.findElement(processedToCheckOut).click();
        driver.findElement(termsAndService).click();
        driver.findElements(proceedToCheckout).get(2).click();
        driver.findElement(paymentCheck).click();
        driver.findElement(orderConfirm).click();



    }
    public void clickSignOutBtn() {
        driver.findElement(signOutBtn).click();
    }
    public void clickCausalDress(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(dressLinkText)).build().perform();
        driver.findElement(casualDressclinkText).click();
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
