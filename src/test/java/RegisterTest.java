import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        driver=new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
        driver.manage().window().maximize();


    }
    @Test
    public void validRegistrationTest(){
        driver.findElement(By.id("firstName")).sendKeys("Asif");
        driver.findElement(By.id("lastName")).sendKeys("Md");

        String email = "asif" + System.currentTimeMillis() + "@mail.com";
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("password")).sendKeys("Test@123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Test@123");

        driver.findElement(By.id("registerBtn")).click();

        // Validation
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("welcome"),
                "Registration failed");
    }

    @Test
    public void registrationWithEmptyFields() {

        driver.findElement(By.id("registerBtn")).click();

        String errorMsg = driver.findElement(By.id("errorMsg")).getText();
        Assert.assertEquals(errorMsg, "All fields are required");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

