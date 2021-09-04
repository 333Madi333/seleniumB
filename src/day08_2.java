import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class day08_2 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

        driver.findElement(By.cssSelector("div#contact-link")).click();

        WebElement selectElement = driver.findElement(By.xpath("//select[@id='id_contact']"));
        Select select = new Select(selectElement);
        Thread.sleep(2000);

        List<WebElement> list = select.getOptions();
        list.forEach(item -> System.out.println(item.getText()));

        select.selectByValue("1");
      System.out.println(select.getFirstSelectedOption().getText());

        driver.close();
    }
}
