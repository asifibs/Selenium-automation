import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();              // local run
            driver.manage().window().maximize();
            driver.get("https://www.flipkart.com/account/login?ret=/");
        }

        @Test
        public void verifyInvalidMobileNumberErrorMessage() {

            // Enter mobile number
            WebElement mobileField = driver.findElement(
                    By.xpath("//input[@class='c3Bd2c yXUQVt']")
            );
            mobileField.click();
            mobileField.sendKeys("1234567890");

            // Click Request OTP
            driver.findElement(
                    By.xpath("//button[normalize-space()='Request OTP']")
            ).click();

            // Capture error message
            WebElement errorMessage = driver.findElement(
                    By.xpath("//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
            );

            System.out.println("Error message: " + errorMessage.getText());
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }



    }

