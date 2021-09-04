import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class day04 {
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
        System.out.println(driver.findElement(By.id("title")).getText());
        System.out.println(driver.findElement(By.cssSelector("h1#title")).getText());

        System.out.println(driver.findElement(By.className("text")).getText());
        System.out.println(driver.findElement(By.cssSelector("div.text")).getText());

        System.out.println(driver.findElement(By.cssSelector("h1[name=h1-text]")).getText());
      driver.close();

    }
}
