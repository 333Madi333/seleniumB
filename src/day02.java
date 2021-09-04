import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://automation.techleadacademy.io/#/home");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("URL lenght: " + driver.getCurrentUrl().length());
        Thread.sleep(2000);

        driver.get("http://amazon.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("URL lenght: " + driver.getCurrentUrl().length());
        Thread.sleep(2000);

        driver.get("http://theinformation.com");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("URL lenght: " + driver.getCurrentUrl().length());
        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}