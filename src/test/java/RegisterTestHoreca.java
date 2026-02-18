import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTestHoreca {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.horecastore.ae/sign-up");

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void registerTest() {

        // Wait until Private checkbox is clickable
        WebElement privateCheckbox = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("private"))
        );

        privateCheckbox.click();

        // Wait until First Name field is visible after page update
        WebElement firstName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Enter your Name']")
                )
        );

        firstName.sendKeys("AsifTesting");

        driver.findElement(By.xpath("//input[@placeholder='Enter your email address']"))
                .sendKeys("testing7474@gmail.com");

        driver.findElement(By.xpath("//input[@placeholder='50 767 8909']"))
                .sendKeys("501234567");

        driver.findElement(By.xpath("//input[@placeholder='Password']"))
                .sendKeys("12345678");

        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"))
                .sendKeys("12345678");

        driver.findElement(By.xpath("//span[normalize-space()='Create an Account']"))
                .click();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}

