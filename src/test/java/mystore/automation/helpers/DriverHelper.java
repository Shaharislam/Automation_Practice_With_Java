package mystore.automation.helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class DriverHelper {
    public static WebDriver driver;
    public static String BASE_URL = "http://automationpractice.com/index.php";

    @BeforeTest
    public void openBrowser() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void takeScreenShot(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            Date currentDate=new Date();
            String screenSortFileName= currentDate.toString().replace(" ","-").replace(":","-");
            File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/screenShot/"+screenSortFileName+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public void closeBrowser() {
       // if (driver != null)
           // driver.quit();
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
