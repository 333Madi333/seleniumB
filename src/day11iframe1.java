import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day11iframe1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/iframes");

        driver.switchTo().frame("parent-iframe");
        driver.switchTo().frame("budget-tracker");
        driver.findElement(By.id("t-name")).sendKeys("check");
        driver.findElement(By.id("t-amount")).sendKeys("3333");
        driver.findElement(By.id("add-btn")).click();
        String total = driver.findElement(By.xpath("//div[@class='total']")).getText();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("note");
        driver.findElement(By.xpath("//input[@class='note-title']")).clear();
        driver.findElement(By.xpath("//input[@class='note-title']")).sendKeys("Madi");
        driver.findElement(By.xpath("//textarea[@class='note-textarea']")).clear();
        driver.findElement(By.xpath("//textarea[@class='note-textarea']")).sendKeys(total);
        driver.findElement(By.xpath("//i[@class='fas fa-save text-light save-note']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Madi']")).click();

        String expected = driver.findElement(By.xpath("//textarea[@class='note-textarea']")).getAttribute("value");

        System.out.println("Actual: " + total);
        System.out.println("Expected: " + expected);

        System.out.println("Are the values the same: " + total.equals(expected));


        driver.close();

    }
}

