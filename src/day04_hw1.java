import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day04_hw1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
//  Print out every product name and price under Popular section
        List<WebElement> product = driver.findElements(By.cssSelector("ul#homefeatured>li.ajax_block_product>div.product-container>div.right-block>h5>a.product-name"));
        List<WebElement> price = driver.findElements(By.cssSelector("ul#homefeatured>li.ajax_block_product>div.product-container>div[class=right-block]>div[class=content_price]>span.price.product-price"));
        for (int i=0; i<product.size();i++){
            System.out.println(product.get(i).getText() + " | " + price.get(i).getText());
        }
//  Open Faded Short Sleeve T-shirts product
        driver.findElement(By.cssSelector("h5[itemprop=name]>[title^=Faded]")).click();
//  Clear quantity item
//  Enter amount = 5
//  Press "Add to cart" button
        driver.findElement(By.cssSelector("input[id=quantity_wanted]")).clear();
        driver.findElement(By.cssSelector("input[id=quantity_wanted]")).sendKeys(String.valueOf(5));
        driver.findElement(By.cssSelector("p[id='add_to_cart']")).click();
//  Adding delay to be able to read numbers from pop-up window
        Thread.sleep(3000);
        System.out.println("");
//  Capture product price, shipping price, total price
        String prevPrice = driver.findElement(By.cssSelector("span[class='ajax_block_products_total']")).getText();
        String prevShip = driver.findElement(By.cssSelector("span[class='ajax_cart_shipping_cost']")).getText();
        String prevTotal = driver.findElement(By.cssSelector("span[class='ajax_block_cart_total']")).getText();
//  Print product price, shipping price, total price
        System.out.println("Product price is : " + prevPrice);
        System.out.println("Shipping price is: " + prevShip);
        System.out.println("Total price is: " + prevTotal);
//  Press "Procees to checkout"
        System.out.println("");
        driver.findElement(By.cssSelector("div.button-container>a")).click();
//  Print out product description
        System.out.println(driver.findElement(By.cssSelector("td.cart_description>p.product-name")).getText());
        System.out.println(driver.findElement(By.cssSelector("td.cart_description>small.cart_ref")).getText());
        System.out.println(driver.findElement(By.cssSelector("td.cart_description>small>a")).getText());
//  Capture total product price, total shipping price, final total price
        String currPrice = driver.findElement(By.cssSelector("tr.cart_total_price>td#total_product")).getText();
        String currShip = driver.findElement(By.cssSelector("tr.cart_total_delivery>td#total_shipping")).getText();
        String currTotal = driver.findElement(By.cssSelector("tr.cart_total_price>td#total_price_container")).getText();
//  Verify current prices with previous prices
        System.out.println("Current product price: " + currPrice+" | Previous product price: " + prevPrice);
        System.out.println("Current shipping price: " + currShip+" | Previous shipping price: " + prevShip);
        System.out.println("Current TOTAL price: " + currTotal+" | Previous TOTAL price:" + prevTotal);
//  close browser
        driver.close();
    }
}
