import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03_task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("DRESSES")).click();

        System.out.println("Casual link: " + (driver.findElement(By.linkText("Casual Dresses"))).getAttribute("href"));
        System.out.println("Evening Dresses: " + (driver.findElement(By.linkText("Evening Dresses"))).getAttribute("href"));
        System.out.println("Summer Dresses: " + (driver.findElement(By.linkText("Summer Dresses"))).getAttribute("href"));

        driver.findElement(By.linkText("Casual Dresses")).click();

        String expected = "CASUAL DRESSES ";
        String actual = driver.findElement(By.className("cat-name")).getText();
        System.out.println(expected.equals(actual));

        driver.navigate().back();

        driver.findElement(By.linkText("Evening Dresses")).click();
        String titleTest = "Evening Dresses - My Store";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle.equals(titleTest));

        driver.close();

    }
}
