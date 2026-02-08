import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandleDropDownWithSelectTag {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost/litecart/en/");
        driver.manage().window().maximize();

        WebElement dropdown=driver.findElement(By.id("Asif"));
        Select select=new Select(dropdown);
        List<WebElement> drpOptions=select.getOptions();
        System.out.println(drpOptions.size());

        //Selecting an option from dropdown
        select.selectByIndex(1);
        select.selectByValue("Asif");
        select.selectByVisibleText("Opel");





    }
}
