import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class day09 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/selectclass");

        Select select = new Select(driver.findElement(By.id("cars")));

        select.selectByValue("Developer");
        select.selectByIndex(7);

        List<WebElement> list = select.getAllSelectedOptions();
        list.forEach(a -> System.out.println(a.getText()));
        select.deselectAll();

        driver.findElement(By.id("exampleRadios1")).click();

        driver.findElement(By.id("defaultCheck1")).click();
        driver.findElement(By.id("defaultCheck3")).click();
        //  driver.close();


    }
}
