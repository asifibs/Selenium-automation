import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set path if required
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com");
    }

    @Test
    public void jsExecutorDemo() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Scroll down
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        // 2. Scroll to element
        WebElement element = driver.findElement(By.tagName("h1"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        // 3. Click using JavaScript
        js.executeScript("arguments[0].click();", element);

        // 4. Enter text using JavaScript
        js.executeScript("document.body.style.backgroundColor='yellow'");

        // 5. Get title using JS
        String title = js.executeScript("return document.title;").toString();
        System.out.println("Page Title: " + title);

        // 6. Refresh page
        js.executeScript("history.go(0)");

        // 7. Zoom page
        js.executeScript("document.body.style.zoom='80%'");

        // 8. Highlight element
        js.executeScript("arguments[0].style.border='3px solid red'", element);

        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
