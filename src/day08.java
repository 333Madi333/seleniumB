import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day08 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("SDET position");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//span[@class='MzfCRe z1asCe lYxQe']")).click();

        Thread.sleep(2000);
//        List<WebElement> companies =  driver.findElements(By.xpath("//div[@class='tl-async-corelist nJXhWc']"));
//        companies.forEach(name -> System.out.println(name.getText()));
        System.out.println(driver.findElement(By.cssSelector("(//div[@class='BjJfJf PUpOsf'])[5]")).getText());
    }
}
