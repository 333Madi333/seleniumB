import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class day13robotDrag {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Actions actions  = new Actions(driver);
        Robot robot  = new Robot();

        Thread.sleep(2000);

        driver.get("http://automation.techleadacademy.io/#/actionclass");

        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("todo1"));
        WebElement element1 = driver.findElement(By.id("div1"));

        System.out.println(element.getLocation());
        System.out.println(element1.getLocation());

        robot.mouseMove(790 , 650);
        Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        robot.mouseMove(1220, 650);
        Thread.sleep(2000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(3000);
        driver.close();

    }
}

