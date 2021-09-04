import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day12Action4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        Thread.sleep(1000);

        WebElement cart = driver.findElement(By.xpath("(//span[@class='etsy-icon'])[2]"));
        action.moveToElement(cart).perform();

        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//span[@role='tooltip']")).getText());



        driver.quit();

    }
}

