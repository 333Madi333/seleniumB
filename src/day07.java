import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class day07 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("The armored group");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).click();

        driver.findElement(By.xpath("(//a[@href=\"https://www.armoredcars.com/armored-vehicles/\"])[2]")).click();

        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@class='wpb_text_column wpb_content_element '])[2]")).getText());

        driver.findElement(By.xpath("(//a[@href='https://www.armoredcars.com/about/'])[3]")).click();

        System.out.println(driver.findElement(By.xpath("(//div[@class='wpb_text_column wpb_content_element '])[2]")).getText());
        System.out.println(driver.findElement(By.xpath("(//div[@class='wpb_text_column wpb_content_element '])[3]")).getText());

        System.out.println(driver.findElement(By.xpath("//ul[@class='served-list']")).getText());

        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/user/armoredcarscompany']")).click();

        List<String> tmp = new ArrayList();
        tmp.add("Apple");



    }
}
