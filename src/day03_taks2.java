import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day03_taks2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        System.out.println(" ");
        System.out.println(driver.findElement(By.id("login_credentials")).getText());
        System.out.println(" ");



        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> tNames = driver.findElements(By.className("inventory_item_name"));
        List<WebElement> tPrice = driver.findElements(By.className("inventory_item_price"));
        for (int i = 0; i < tNames.size(); i++) {
            System.out.println("Name: " + tNames.get(i).getText() + "  Price: " + tPrice.get(i).getText());
        }

        //        list.forEach(element -> System.out.println(element.getText()));

        driver.findElement(By.className("inventory_item_img")).click();

        System.out.println(" ");

        System.out.println("Name: " + driver.findElement(By.className("inventory_details_name")).getText());
        System.out.println("Description: " + driver.findElement(By.className("inventory_details_desc")).getText());
        System.out.println("Price: " + driver.findElement(By.className("inventory_details_price")).getText());


      //  driver.quit();

    }
}
