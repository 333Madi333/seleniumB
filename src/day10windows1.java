import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class day10windows1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //1. open http://automation.techleadacademy.io/#/multiplewindow
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");

        //2. print out 3 text of 3 buttons
        List<WebElement> buttons = driver.findElements(By.xpath("//a[starts-with(@class,'btn')]"));
        buttons.forEach(button -> System.out.println(button.getText()));

        //Capturing id of the current window
        String currentWindowID = driver.getWindowHandle();

        //3. open Facebook link
        buttons.get(2).click();

        Thread.sleep(2000);

        //switching the driver to second window
        Set<String> windows = driver.getWindowHandles();
        for (String windowId : windows) {
            if (!windowId.equals(currentWindowID))
                driver.switchTo().window(windowId);
        }

        //4. print out "Connect with friend and the world..." text
        System.out.println(driver.findElement(By.xpath("//h2")).getText());

        //5. Close facebook window
        driver.close();

        //6. return to main window (tla practice website)
        driver.switchTo().window(currentWindowID);

        Thread.sleep(2000);

        //7. open Google link
        buttons.get(1).click();

        Thread.sleep(2000);
        Set<String> windows2 = driver.getWindowHandles();
        for (String windowId : windows2) {
            if (!windowId.equals(currentWindowID))
                driver.switchTo().window(windowId);
        }

        //8. print out title of the Google page
        System.out.println(driver.getTitle());

        driver.switchTo().window(currentWindowID);

        //9 Click Launch TLA
        buttons.get(0).click();

        Thread.sleep(2000);
        Set<String> windows3 = driver.getWindowHandles();
        for (String windowId : windows3) {
            if (!windowId.equals(currentWindowID))
                driver.switchTo().window(windowId);
        }

        //10 Print out text of navigation bar buttons
        driver.manage().window().maximize();

        List<WebElement> navBtns = driver.findElements(By.xpath("//div[@id='lp-pom-box-287']//p/a"));
        navBtns.forEach(button -> System.out.println(button.getText()));

        Thread.sleep(3000);
        driver.quit();
    }
}

