import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;


public class day14javaSEatributeStyle {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("http://automation.techleadacademy.io/#/home");
        Thread.sleep(2000);

        WebElement h1Element = driver.findElement(By.xpath("//h1"));
        js.executeScript("arguments[0].style.backgroundColor='yellow'", h1Element);
        js.executeScript("arguments[0].style.border='solid 2px red'", h1Element);

        Thread.sleep(3000);
        driver.close();
    }


}

