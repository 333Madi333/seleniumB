import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().window().maximize();
        String url = "https://www.google.com/";

        driver.get(url);

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        System.out.println(expectedTitle.equals(actualTitle));

        driver.close();
    }
}
