import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day05 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        Thread.sleep(2000);
        List<WebElement> addBtns = driver.findElements(By.cssSelector("div.shelf-item__buy-btn"));

        addBtns.get(0).click();
        addBtns.get(4).click();
        addBtns.get(8).click();

        Thread.sleep(2000);
        List<WebElement> cartPrices = driver.findElements(By.cssSelector("div.float-cart__shelf-container div.shelf-item__price"));

        double total = 0;

        for (WebElement each : cartPrices) {
            String price = each.getText().substring(2, 7);
            total += Double.parseDouble(price);
        }

        System.out.println(total);

        WebElement totalPrice = driver.findElement(By.cssSelector(".sub-price__val"));
        double actualTotal = Double.parseDouble(totalPrice.getText().substring(2));

        System.out.println(total == actualTotal);
        System.out.println("Total: " + total + " | actual: " + actualTotal);

        driver.close();
    }
}
