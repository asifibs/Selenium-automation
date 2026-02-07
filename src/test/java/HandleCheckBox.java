import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckBox {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();
        //select specific one checkbox
        driver.findElement(By.xpath("//input[@id='monday']")).click();
        //total no of checkboxes
        List<WebElement> checkbox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println(checkbox.size());

       /* for(WebElement chk:checkbox) //using for loop
        {
            chk.click();
        }*/
        for(int i=0; i<checkbox.size();i++) //normal loop
        {
            checkbox.get(i).click();
        }
        //select first 2 checkbox
        for(int i=0;i<3;i++)
        {
            checkbox.get(i).click();

        }
        //clear /uncheck checkboxes
        for(int i=0;i<3;i++) //normal for loop
        {
            checkbox.get(i).click();
        }

        for(int i=0;i<checkbox.size();i++)
        {
            if(checkbox.get(i).isSelected())
            {
                checkbox.get(i).click();
            }
        }
        //for loop
        for(WebElement chkbox:checkbox)
        {
            if(chkbox.isSelected())
            {
                chkbox.click();
            }
        }

    }
}
