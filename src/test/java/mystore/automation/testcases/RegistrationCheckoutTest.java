package mystore.automation.testcases;

import com.github.javafaker.Faker;
import com.opencsv.exceptions.CsvValidationException;
import mystore.automation.helpers.DriverHelper;
import mystore.automation.webpages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;


public class RegistrationCheckoutTest extends DriverHelper {
    String emailFirstUser = new Faker().internet().emailAddress();
    String emailSecondUser = new Faker().internet().emailAddress();
    String passwordFirstUser = "pass@123456";
    String passwordSecondUser = "pass@654321";

    HomePage homePage = new HomePage();
    LoginPage login = new LoginPage();
    PurchaseProduct purchase = new PurchaseProduct();
    CsvFileTest printData=new CsvFileTest();
    DataStore useData=new DataStore();

//    @DataProvider(name = "register-data")
//    public Object[][] userData() {
//        return new Object[][]{
//                {emailFirstUser, passwordFirstUser},
//                {emailSecondUser, passwordSecondUser}
//        };
//    }

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
        purchase.clickCausalDress();
        purchase.addToCartAndProceedCheckout();
        Assert.assertEquals(login.successMessageDisplayed(), "Your order on My Store is complete.");
        login.clickSignOutBtn();
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }

    @Test(priority = 3, description = "Login new account second user and purchase product")
    public void purchaseProductWithSecondUser() {
        login.clickSignInBtn();
        login.fillUserCredential(emailSecondUser, passwordSecondUser);
        login.clickSubmitBtn();
        purchase.clickCausalDress();
        purchase.addToCartAndProceedCheckout();
        Assert.assertEquals(login.successMessageDisplayed(), "Your order on My Store is complete.");
        login.clickSignOutBtn();
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }

    @Test(priority = 4, description = "Csv File Read and Print Data", dataProvider = "register-data")
    public void CsvDataPrint(String email, String password) throws CsvValidationException, IOException {
        printData.CsvFileReadMethod();
//        homePage.clickLoginButton();
//        homePage.setEmailAddress(email);
//        homePage.clickSubmitButton();
//        homePage.fillPersonalInformation(password);
//        homePage.clickSubmitAccount();
//        Assert.assertTrue(homePage.getUserName());
//        Assert.assertEquals(driver.getTitle(), "My account - My Store");
//        homePage.clickSignOutBtn();
    }

    @DataProvider(name = "userdata", parallel = false)
    public Object[][] getUsersData() {
        String users_csv ="src/test/ExcelSheet/users.csv";
        return printData.readCsvData(users_csv);
    }

    @Test(testName = "Search on Google with single browser.", dataProvider = "userdata")
    public void googleSearchTest(Object[] data) {
        System.out.println(Arrays.asList(data));
//        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
//        searchPage.clickAgreeButton();
//        searchPage.insertSearchText(data[0].toString());
    }
    @DataProvider(name = "testUserData", parallel = false)
    public Object[][] getData() {
        String use_csv ="src/test/ExcelSheet/userlist.csv";
        return useData.receiveCsvData(use_csv);
    }

    @Test(testName = "Search on Google with single browser.", dataProvider = "testUserData")
    public void dataSearchTest(Object[] data) {
        String email= (String) data[0];
        String pass= (String) data[1];
       // System.out.println(Arrays.asList(data));
        //System.out.println("Data[0]:= "+data[0]+" Data[1]:= "+data[1]);
        System.out.println();
        homePage.clickLoginButton();
        homePage.setEmailAddress(email);
        homePage.clickSubmitButton();
        homePage.fillPersonalInformation(pass);
        homePage.clickSubmitAccount();
        Assert.assertTrue(homePage.getUserName());
        Assert.assertEquals(driver.getTitle(), "My account - My Store");
        homePage.clickSignOutBtn();
//        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
//        searchPage.clickAgreeButton();
//        searchPage.insertSearchText(data[0].toString());
    }
}
