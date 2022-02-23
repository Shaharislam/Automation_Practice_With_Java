package mystore.automation.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class DriverHelper {
    public static WebDriver driver;
    public static String BASE_URL = "http://automationpractice.com/index.php";

    @BeforeTest
    public void openBrowser() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null)
            driver.quit();
    }

    public static void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");
        sleep(1);
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
