import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.WatchEvent;

public class day12Action {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Actions action = new Actions(driver);

//        driver.get("https://www.amazon.com/");
//
//        Thread.sleep(3000);
//        action.moveToElement(driver.findElement(By.xpath("//li[@class='nav_last']"))).perform();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/actionclass");
        Thread.sleep(3000);

        WebElement doubleClickBtn = driver.findElement(By.xpath("//div[@class='container']//button[2]"));
        action.doubleClick(doubleClickBtn).perform();

        WebElement workout = driver.findElement(By.id("todo1"));
        WebElement target = driver.findElement(By.id("div1"));
        action.dragAndDrop(workout, target).perform();


//        WebElement rightClickBtn = driver.findElement(By.xpath("//div[@class='container']//button[3]"));


//        action.moveToElement(rightClickBtn).perform();
//        action.contextClick().perform();

//        action.moveToElement(rightClickBtn).contextClick().perform();
//        action.contextClick(rightClickBtn).perform();

        Thread.sleep(3000);
        driver.close();



    }
}

