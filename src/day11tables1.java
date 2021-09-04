import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class day11tables1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amctheatres.com/");
        System.out.println(driver.findElement(By.xpath("//p[@class='onboarding-tour-modal__body']")).getText());
        driver.findElement(By.xpath("//button[@class='Btn Btn--Primary']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//p[@class='tourtip__content']")).getText());
        driver.findElement(By.xpath("//i[@class='icon icon_close icon--small']")).click();

        String amc = driver.getWindowHandle();

        driver.findElement(By.xpath("//i[@class='icon_facebook']")).click();
        driver.findElement(By.xpath("//i[@class='icon_twitter']")).click();
        driver.findElement(By.xpath("//i[@class='icon_youtube']")).click();
        driver.findElement(By.xpath("//i[@class='icon_instagram']")).click();
        driver.findElement(By.xpath("//i[@class='icon_pinterest']")).click();


        System.out.println(driver.getTitle());

        Set<String> windows = driver.getWindowHandles();

        for(String eachWindow: windows){
            if (!eachWindow.equalsIgnoreCase(amc)){
                driver.switchTo().window(eachWindow);
            }
        }

        String fb = driver.getWindowHandle();
         for(String eachWindow: windows){
            if (!eachWindow.equalsIgnoreCase(amc)&&!eachWindow.equalsIgnoreCase(fb)){
                driver.switchTo().window(eachWindow);
            }
        }
        String twitt = driver.getWindowHandle();
        for(String eachWindow: windows){
            if (!eachWindow.equalsIgnoreCase(amc)&&!eachWindow.equalsIgnoreCase(fb)&&!eachWindow.equalsIgnoreCase(twitt)){
                driver.switchTo().window(eachWindow);
            }
        }
        String youtube = driver.getWindowHandle();
        for(String eachWindow: windows){
            if (!eachWindow.equalsIgnoreCase(amc)&&!eachWindow.equalsIgnoreCase(fb)&&!eachWindow.equalsIgnoreCase(twitt)&&!eachWindow.equalsIgnoreCase(youtube)){
                driver.switchTo().window(eachWindow);
            }
        }
        String inst = driver.getWindowHandle();
        for(String eachWindow: windows){
            if (!eachWindow.equalsIgnoreCase(amc)&&!eachWindow.equalsIgnoreCase(fb)&&!eachWindow.equalsIgnoreCase(twitt)&&!eachWindow.equalsIgnoreCase(youtube)&&!eachWindow.equalsIgnoreCase(inst)){
                driver.switchTo().window(eachWindow);
            }
        }
        String pin = driver.getWindowHandle();

        System.out.println(driver.findElement(By.xpath("//span[@class='tBJ dyH iFc yTZ pBj zDA mWe']")).getText()+" follower | " + driver.findElement(By.xpath("(//span[@class='tBJ dyH iFc yTZ pBj zDA mWe'])[2]")).getText() + " following");

        driver.switchTo().window(inst);

     // driver.quit();
    }
}

