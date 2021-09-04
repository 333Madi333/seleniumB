import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        driver.findElement(By.linkText("English")).click();

        driver.findElement(By.name("q")).sendKeys("Selenium");

        Thread.sleep(2000);
        driver.findElement(By.name("btnK")).click();

//Test 1: Verify link of wikipedia is correct
        String expectedWikiLink = "https://en.wikipedia.org/wiki/Selenium_(software)";

        Thread.sleep(3000);

//Dont worry about xpath at the moment!
        String actualWikiLink = driver.findElement(By.xpath("//a[@class='ruhjFe NJLBac fl']")).getAttribute("href");

        System.out.println("Test result passed: " + expectedWikiLink.equalsIgnoreCase(actualWikiLink));

        WebElement resultItem = driver.findElement(By.className("LC20lb"));

        System.out.println("Does first item has Selenium keyword: " + resultItem.getText().contains("Selenium"));

        System.out.println(driver.findElement(By.linkText("Shopping")).isEnabled());

        driver.close();

    }
}
