import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day04_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/home");

        //css = tag + attribute
        //1 #-id div#title
        //2 .-class dib.class
        //3 tag[name='valueOfName']
        //chain tag[name='valueOfName'][name='valueOfName'][name='valueOfName']...

        //Parent-child relation
        // parentLocation>chilLocation
//        List<WebElement> nav = driver.findElements(By.cssSelector("a[class*='navbar-brand']"));
//        nav.forEach(name -> System.out.println(name.getText()));
//
//        System.out.println(" ");

        driver.findElement(By.cssSelector("a[href='#/selectors']")).click();
//        System.out.println(driver.findElement(By.cssSelector("div#lamborghini")).getText());

//        System.out.println(driver.findElement(By.cssSelector("div[class='body-container']>nav[class='navbar nav1']:first-child>a:nth-child(6)")).getText());
        System.out.println(driver.findElement(By.cssSelector("div#parent2>div:last-child>div:nth-child(4)")).getText());

        driver.close();
    }
}
