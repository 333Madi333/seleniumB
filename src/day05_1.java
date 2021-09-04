import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day05_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/notes");
//1
        System.out.println("1");
        System.out.println(driver.findElement(By.cssSelector("p#first-list-item")).getText());

//2
        System.out.println("2");
        System.out.println(driver.findElement(By.cssSelector("p[class='sc-eCApnc iylGhi']")).getText());
//3
        System.out.println("3");
        System.out.println(driver.findElement(By.cssSelector("p[title=attribute]")).getText());

//4
        System.out.println("4");
        System.out.println(driver.findElement(By.cssSelector("p[title=chaining][class='sc-eCApnc iylGhi']")).getText());

//5
        System.out.println("5");
        System.out.println(driver.findElement(By.cssSelector("p[title=chaining]")).getText());
//6
        System.out.println("6");
        System.out.println(driver.findElement(By.cssSelector("p[title=chaining]")).getText());
        // driver.close();
    }
}
