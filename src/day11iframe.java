import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Set;

public class day11iframe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/iframes");
        driver.switchTo().frame("note");

        driver.findElement(By.xpath("//input[@class='note-title']")).clear();
        driver.findElement(By.xpath("//input[@class='note-title']")).sendKeys("Madi");
        driver.findElement(By.xpath("//textarea[@class='note-textarea']")).clear();
        driver.findElement(By.xpath("//textarea[@class='note-textarea']")).sendKeys("Hello Madi!");
        driver.findElement(By.xpath("//i[@class='fas fa-save text-light save-note']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Madi']")).click();
        String actual = driver.findElement(By.xpath("//span[text()='Madi']")).getText();
        Thread.sleep(2000);
        String expected = driver.findElement(By.xpath("//input[@class='note-title']")).getAttribute("value");

        System.out.println(actual);
        System.out.println(expected);

        if (actual.equals(expected)) {
            System.out.println(driver.findElement(By.xpath("//textarea[@class='note-textarea']")).getAttribute("value"));
        }
    }
}

