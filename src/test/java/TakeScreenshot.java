import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void captureHomePageScreenshot() throws IOException {
        driver.get("https://example.com/");
        takeScreenshot(driver, "homepage");
    }

    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        File screenshotsDir = new File("./screenshots");
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotsDir, fileName + ".png");
        FileHandler.copy(src, dest);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
