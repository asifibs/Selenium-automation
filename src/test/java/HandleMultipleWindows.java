import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleMultipleWindows {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/account/login?ret=/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Terms of Use']")).click();
        Set<String> windowIDS=driver.getWindowHandles();
        //Approch 1
       /* List<String> windowsList=new ArrayList<>(windowIDS);
        String parentWindowID=windowsList.get(0);
        String childWindowID=windowsList.get(1);
        driver.switchTo().window(childWindowID);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        //switch to parent window
        driver.switchTo().window(parentWindowID);*/

        //Approch2
        for(String winID:windowIDS)
        {
            String title=driver.switchTo().window(winID).getTitle();
            if(title.equals("Flipkart"))
            {
                System.out.println(driver.getCurrentUrl());
            }
        }


    }
}
