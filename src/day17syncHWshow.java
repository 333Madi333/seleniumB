import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class day17syncHWshow {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.get("https://weather.com/");

        WebElement popUp = driver.findElement(By.xpath("//div[@class='PrivacyDataNotice--notice--5SUaf']"));
        System.out.println(popUp.getText());

        driver.findElement(By.xpath("//*[@name='close']")).click();

        List<WebElement> icons = driver.findElements(By.xpath("//ul[@class='LinkList--LinkList--2qcvb Footer--linklist--1oQyV Footer--socialLinks--3gaYZ LinkList--inline-no-border--3rBYV']/li/a"));

        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//footer)[8]")));
        Thread.sleep(3000);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("(//footer)[8]")));

        for (int i = 0; i < icons.size(); i++) {
            if (i != 2) {
                try {
                    icons.get(i).click();
                } catch (ElementClickInterceptedException e) {
                    icons.get(i).click();
                }
            }
        }

        String currentWindowID = driver.getWindowHandle();

        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String each : allWindowIDs) {
            if (!each.equals(currentWindowID)) {
                driver.switchTo().window(each);
                System.out.println(driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(currentWindowID);

        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//span[text()='10 Day']")).click();
        } catch (ElementClickInterceptedException e) {
            driver.findElement(By.xpath("//span[text()='10 Day']")).click();
        }

        Thread.sleep(2000);
        driver.findElement(By.name("caret-up")).click();
        Thread.sleep(2000);

        List<WebElement> forecastDaily = driver.findElements(By.xpath("//details[@class='Disclosure--themeList--25Q0H']"));

        System.out.println("---------------------------");
        for (WebElement each : forecastDaily) {
            String day = each.findElement(By.xpath(".//h2")).getText();
            String temperature = each.findElement(By.xpath(".//div[@data-testid='detailsTemperature']")).getText();
            String condition = each.findElement(By.xpath(".//span[@class='DetailsSummary--extendedData--365A_']")).getText();
            System.out.println(day + " - " + temperature + " - " + condition);
        }


        Thread.sleep(3000);
        driver.quit();
    }
}


