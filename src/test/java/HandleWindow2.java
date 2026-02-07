import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleWindow2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com/account/login?ret=/");

// Close login popup
        driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();

        // Store parent window
        String parentWindowID = driver.getWindowHandle();

// Click Terms of Use
        driver.findElement(By.xpath("//a[normalize-space()='Terms of Use']")).click();

// Switch to child window
        for (String windowID : driver.getWindowHandles()) {
            if (!windowID.equals(parentWindowID)) {
                driver.switchTo().window(windowID);
                break;
            }
        }

// Perform action in child window
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

// Switch back to parent window
        driver.switchTo().window(parentWindowID);

    }
}
