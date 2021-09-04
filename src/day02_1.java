import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/home");


        WebElement phpTravelLink = driver.findElement(By.className("link"));
        System.out.println(phpTravelLink.getText());
        System.out.println(phpTravelLink.getTagName());
        phpTravelLink.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
