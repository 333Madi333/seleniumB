import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class day08_hwSelect {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement sel = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(sel);

        List<WebElement> list = select.getOptions();
        list.forEach(item -> System.out.println(item.getText()));

        Thread.sleep(2000);
        select.selectByValue("lohi");
        select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));

        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        String res = "";
        for(int i=0; i<price.size()-1; i++){
            String currentPrice = price.get(i).getText();
            String nextPrice = price.get(i+1).getText();

            double price1=Double.parseDouble(currentPrice.substring(1));
            double price2=Double.parseDouble(nextPrice.substring(1));

            if(price1>price2){
                res = "Test FAILED";
                System.out.println("Price1: "+ price1 + "| Price 2: " + price2);
            }
            else {
                res = "Test Passed";
            }
          }
        System.out.println(res);
     driver.close();
    }
}
