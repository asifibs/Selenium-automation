import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("...")).click();
        //1st Method
        Set<String> list=driver.getWindowHandles();
        List<String> list2=new ArrayList<>(list);
        String parentWindow=list2.get(0);
        String childWindow=list2.get(1);
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("")).sendKeys("Asif");
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath( "")).click();

        //Another Method
        for(String WindowID:list)
        {
            String title=driver.switchTo().window(WindowID).getTitle();
            if(title.equals("New York"))
            {
                System.out.println(driver.getCurrentUrl());
            }


        }




    }
}
