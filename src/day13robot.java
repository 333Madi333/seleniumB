import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class day13robot {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Actions actions  = new Actions(driver);
        Robot robot  = new Robot();

        Thread.sleep(2000);

        driver.get("http://automation.techleadacademy.io/#/files");

//        StringSelection path = new StringSelection("C:\\Users\\jakyp\\Desktop\\New Text Document.txt");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);

        WebElement button = driver.findElement(By.id("exampleFormControlFile1"));
        actions.moveToElement(button).click().perform();

        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);




      driver.quit();

    }
}

