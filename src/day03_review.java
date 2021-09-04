import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_review {
    public static void main(String[] args)   {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/home");

        WebElement element = driver.findElement(By.partialLinkText("Passion"));
        WebElement home = driver.findElement(By.linkText("Home"));

        System.out.println(home.getText());
        System.out.println(element.getText());

        driver.close();
    }
}
