package mystore.automation.webpages;

import com.github.javafaker.Faker;
import mystore.automation.helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends DriverHelper {
    String firstNameText = new Faker().name().firstName();
    String lastNameText = new Faker().name().lastName();
    String userNameText = firstNameText + " " + lastNameText;
    String companyText = new Faker().company().name();
    String setOthersText = new Faker().lorem().characters(100);
    String setPhoneNumber = new Faker().number().digits(10);
    String setMobileNumber = new Faker().number().digits(10);
    String aliseAddress = new Faker().lorem().characters(10);

    By signInLocator = By.className("login");
    By emailLocator = By.id("email_create");
    By submitLocator = By.id("SubmitCreate");
    By cFirstName = By.id("customer_firstname");
    By cLastName = By.id("customer_lastname");
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By password = By.id("passwd");
    By daysOptionLocator = By.id("uniform-days");
    By daysLocator = By.id("days");
    By monthOptionsLocator = By.id("uniform-months");
    By monthLocator = By.id("months");
    By yearOptionsLocator = By.id("uniform-years");
    By yearLocator = By.id("years");
    By submitAccount = By.id("submitAccount");
    By userName = By.xpath("//a[@title='View my customer account']");
    By alias = By.id("alias");
    By phoneMobile = By.id("phone_mobile");
    By newsLetterCheckBox = By.id("newsletter");
    By specialCheckBox = By.id("optin");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By city = By.id("city");
    By uniformState = By.id("uniform-id_state");
    By stateNameLocator = By.id("id_state");
    By postCode = By.id("postcode");
    By otherText = By.id("other");
    By phone = By.id("phone");
    By countryName = By.id("id_country");
    By genderMale = By.id("uniform-id_gender1");
    By signOutBtn = By.xpath("//a[@title='Log me out']");

    public boolean getUserName() {
        return driver.findElement(userName).getText().equals(userNameText);
    }

    public void clickSubmitAccount() {
        driver.findElement(submitAccount).click();
    }

    public void clickLoginButton() {
        driver.findElement(signInLocator).click();
    }

    public void setEmailAddress(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void clickSubmitButton() {
        driver.findElement(submitLocator).submit();
    }

    public void setCompany(String companyName) {
        driver.findElement(company).sendKeys(companyName);
    }

    public void setAddress1(String addrs1) {
        driver.findElement(address1).sendKeys(addrs1);
    }

    public void setAddress2(String addrs1) {
        driver.findElement(address2).sendKeys(addrs1);
    }

    public void setCity(String cityName) {
        driver.findElement(city).sendKeys(cityName);
    }

    public void setStateName(String id_state) {
        driver.findElement(uniformState).click();
        Select select = new Select(driver.findElement(stateNameLocator));
        select.selectByVisibleText(id_state);
    }

    public void setPostCode(String code) {
        driver.findElement(postCode).sendKeys(code);
    }

    public void setCountryName(String id_country) {
        driver.findElement(countryName).sendKeys(id_country);
    }

    public void setPhone(String phoneNumber) {
        driver.findElement(phone).sendKeys(phoneNumber);
    }

    public void setPhoneMobile(String phone_mobile) {
        driver.findElement(phoneMobile).sendKeys(phone_mobile);
    }

    public void setAlias(String alias_text) {
        driver.findElement(alias).sendKeys(alias_text);
    }

    public void selectDays(String day) {
        driver.findElement(daysOptionLocator).click();
        Select select = new Select(driver.findElement(daysLocator));
        select.selectByValue(day);
    }

    public void selectMonths(String month) {
        driver.findElement(monthOptionsLocator).click();
        Select select = new Select(driver.findElement(monthLocator));
        select.selectByValue(month);
    }

    public void selectYears(String year) {
        driver.findElement(yearOptionsLocator).click();
        Select select = new Select(driver.findElement(yearLocator));
        select.selectByValue(year);
    }

    public void clickNewsLetter() {
        driver.findElement(newsLetterCheckBox).click();
    }

    public void clickSpecialOffers() {
        driver.findElement(specialCheckBox).click();
    }

    public void setOtherText(String text) {
        driver.findElement(otherText).sendKeys(text);
    }

    public void clickSignOutBtn() {
        driver.findElement(signOutBtn).click();
    }

    public void fillPersonalInformation(String Pass) {
        driver.findElement(genderMale).click();
        driver.findElement(cFirstName).sendKeys(firstNameText);
        driver.findElement(cLastName).sendKeys(lastNameText);
        driver.findElement(password).sendKeys(Pass);

        selectDays("1");
        selectMonths("1");
        selectYears("1990");
        clickNewsLetter();
        clickSpecialOffers();

        driver.findElement(firstName).sendKeys(firstNameText);
        driver.findElement(lastName).sendKeys(lastNameText);

        setCompany(companyText);
        setAddress1("House# 35, Road# 1, Mirpur-11");
        setAddress2("House# 35, Road# 1, Mirpur-11");
        setCity("Pallabi");
        setStateName("Alaska");
        setPostCode("12168");
        setCountryName("United States");

        setOtherText(setOthersText);
        setPhone(setPhoneNumber);
        setPhoneMobile(setMobileNumber);
        setAlias(aliseAddress);
    }
}
