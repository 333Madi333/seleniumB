import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day04_task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/home");

        driver.findElement(By.cssSelector("a[href='#/selectors']")).click();
        System.out.println(driver.findElement(By.cssSelector("div[name=aventador]")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[name=huracan]")).getText());

        System.out.println(driver.findElement(By.cssSelector("div[id=porsche][class=make]>h2")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[id=porsche]>div[class='vehicle-types row']>div:nth-child(1)")).getText());
        System.out.println(driver.findElement(By.cssSelector("div[id=porsche]>div[class='vehicle-types row']>div:nth-child(2)")).getText());

        driver.close();
    }
}
