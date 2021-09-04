import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class day15ImplicitPract1 {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/synchronization");
        WebDriverWait wait = new WebDriverWait(driver, 60);


        driver.findElement(By.xpath("//input[@class='form-control m-2']")).sendKeys("Detroit");
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("city"))));
        System.out.println(driver.findElement(By.id("city")).getText());
        System.out.println(driver.findElement(By.id("result")).getText());

        driver.close();
    }
}

