import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class day17syncHW {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        driver.get("https://weather.com");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String weatherCom = driver.getWindowHandle();
//        Print out pop up window text.
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='PrivacyDataNotice--notice--5SUaf']"))));
        System.out.println(driver.findElement(By.id("privacy-data-notice")).getText());
        System.out.println("");
        driver.findElement(By.xpath(" //*[local-name()='svg' and @name='close' ]")).click();
        Thread.sleep(2000);
//        Scroll down to social network buttons
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//p[@class='Footer--privacyLinksParagraph--1qtvH']")));
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//p[@class='Footer--privacyLinksParagraph--1qtvH']")));
//        Open FaceBook page and print title
        WebElement fb = driver.findElement(By.xpath(" //*[local-name()='svg' and @name='facebook' ]"));
        action.moveToElement(fb).click().perform();

        Set<String> windows = driver.getWindowHandles();
        for (String windowId : windows) {
            if (!windowId.equals(weatherCom))
                driver.switchTo().window(windowId);
        }
        System.out.println("FaceBook title: " + driver.getTitle());
        String faceBook = driver.getWindowHandle();
        driver.switchTo().window(weatherCom);
//        Open Twitter page and print title
        WebElement tw = driver.findElement(By.xpath(" //*[local-name()='svg' and @name='twitter' ] "));
        action.moveToElement(tw).click().perform();
        Set<String> windows1 = driver.getWindowHandles();
        for (String windowId : windows1) {
            if (!windowId.equals(weatherCom))
                driver.switchTo().window(windowId);
        }
        System.out.println("Twitter title: " + driver.getTitle());
        String twitter = driver.getWindowHandle();
        driver.switchTo().window(weatherCom);
//        Open YouTube page and print title
        WebElement yt = driver.findElement(By.xpath("  //*[local-name()='svg' and @name='youtube' ]"));
        action.moveToElement(yt).click().perform();
        Set<String> windows2 = driver.getWindowHandles();
        for (String windowId : windows2) {
            if (!windowId.equals(weatherCom))
                driver.switchTo().window(windowId);
        }
        System.out.println("YouTube title: " + driver.getTitle());
        String youTube = driver.getWindowHandle();
//        Close Facebook, Twitter, Youtube switch to the Weather.com
        driver.switchTo().window(faceBook).close();
        driver.switchTo().window(twitter).close();
        driver.switchTo().window(youTube).close();
        driver.switchTo().window(weatherCom);
        System.out.println("");
//        Scroll up to find "10 day" button and click on it
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("LocationSearch_input")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='10 Day']")).click();
//        Minimizing today window
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[local-name()='svg' and @name='caret-up' ]")).click();
//        Creating a list of Date Temp and Condition WebElents
        List<WebElement> date = driver.findElements(By.xpath("//h2[@data-testid='daypartName']"));
        List<WebElement> tempHi = driver.findElements(By.xpath("//span[@class='DetailsSummary--highTempValue--3Oteu']"));
        List<WebElement> tempL = driver.findElements(By.xpath("//span[@class='DetailsSummary--lowTempValue--3H-7I']"));
        List<WebElement> cond = driver.findElements(By.xpath("//span[@class='DetailsSummary--extendedData--365A_']"));
//        Print data from the Lists
        for (int i = 0; i < date.size(); i++) {
            System.out.println("Date: " + date.get(i).getText() + " Temp: " + tempHi.get(i).getText() + "/" + tempL.get(i).getText() + " Conditions:" + cond.get(i).getText());
        }
        driver.close();
    }
}

