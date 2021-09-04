import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day08_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/selectors");

        //tag[@attr='value']/following-sibling::tag
        //div[@id='parent2-child3']/div[2]/following-sibling::div
//        List<WebElement> cars =  driver.findElements(By.xpath("//div[@id='porsche']/div/div/child::div"));
//        cars.forEach(name -> System.out.println(name.getText()));
//        List<WebElement> cars1 =  driver.findElements(By.xpath("//div[@class='vehicle-type']/following::div[@name]"));
//        cars1.forEach(name -> System.out.println(name.getText()));

        List<WebElement> cars1 =  driver.findElements(By.xpath("(//div[@class=\"vehicle-type\"])[2]/following-sibling::div"));
        cars1.forEach(name -> System.out.println(name.getText()));
    }
}
