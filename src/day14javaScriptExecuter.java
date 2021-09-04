import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

public class day14javaScriptExecuter {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions  = new Actions(driver);
        driver.get("http://automation.techleadacademy.io/#/actionclass");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();

        System.out.println(title);
        Thread.sleep(2000);

        WebElement homeBtn = driver.findElement(By.linkText("Home"));

        js.executeScript("arguments[0].click();", homeBtn);

        Thread.sleep(3000);
        driver.close();
    }
}

