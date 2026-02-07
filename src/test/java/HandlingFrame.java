import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingFrame {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/frames");

// Switch to frame using WebElement (BEST PRACTICE)
        WebElement frame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);

// Action inside frame
        String text = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(text);

// Come back to main page
        driver.switchTo().defaultContent();

    }
}
