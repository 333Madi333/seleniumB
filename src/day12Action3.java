import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class day12Action3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Actions action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/iframes");
        Thread.sleep(1000);

        driver.switchTo().frame("parent-iframe");

        System.out.println(driver.findElement(By.xpath("(//body/div[@id='iframe-text'])")).getText());

        WebElement hello = driver.findElement(By.xpath("(//body/div[@id='iframe-text'])"));
        action.click().doubleClick().perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        driver.get("http://automation.techleadacademy.io/#/inputs");
        Thread.sleep(2000);
        WebElement inputField = driver.findElement(By.id("message"));
        action.keyDown(inputField, Keys.CONTROL).sendKeys("v").perform();

        Thread.sleep(3000);
        driver.quit();

    }
}

