import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day06 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.practiceselenium.com/");

        System.out.println(driver.findElement(By.xpath("//a[@href='our-passion.html']")).getText());
//        System.out.println(driver.findElement(By.xpath("//a[@href='menu.html']")).getText());
        System.out.println(driver.findElement(By.xpath("//a[@data-pageid='00000000-0000-0000-0000-000009816342']")).getText());
        System.out.println(driver.findElement(By.xpath("//a[@href='let-s-talk-tea.html']")).getText());
        System.out.println(driver.findElement(By.xpath("//a[@href='check-out.html']")).getText());
        driver.findElement(By.xpath("//a[@href='our-passion.html' ]")).click();
        System.out.println(" ");
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000450914914']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000450914902']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000450914903']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000450914920']")).getText());
        System.out.println(" ");
        driver.findElement(By.xpath("//a[@href='menu.html']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453230000']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453231072']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453231735']")).getText());
        System.out.println(" ");
        driver.findElement(By.xpath("//a[@href='check-out.html']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@mail.com");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("John");
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("132 main");
        driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("5464654654654654654");
        driver.findElement(By.xpath("//input[@id='cardholder_name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='verification_code']")).sendKeys("123");
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();


        driver.close();

    }
}
