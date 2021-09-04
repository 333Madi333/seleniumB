import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;

public class day14javaScriptExecuterScroll {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("http://amazon.com");
        Thread.sleep(2000);

        WebElement bottom = driver.findElement(By.className("navFooterDescItem"));
        js.executeScript("arguments[0].scrollIntoView(true)", bottom);

        Thread.sleep(4000);

        List<WebElement> bottomElements = driver.findElements(By.xpath("//div[@class='a-row a-size-small']"));
        System.out.println(bottomElements.size());

        Thread.sleep(3000);
        driver.close();
    }
}

