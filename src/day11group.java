import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class day11group {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amctheatres.com/");
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.xpath("//h5[@class='onboarding-tour-modal__headline']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[@class='onboarding-tour-modal__body']")).getText());
        System.out.println("----------");

        driver.findElement(By.xpath("//button[@class='Btn Btn--Primary']")).click();
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.xpath("//div[@class='tourtip__header']")).getText());
        System.out.println(driver.findElement(By.xpath("//p[@class='tourtip__content']")).getText());
        System.out.println("----------");

        driver.findElement(By.xpath("//button[@class='Btn Btn--icon tourtip__container-close']")).click();
        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='u-listUnstyled'])[3]/li"));
        list.forEach(button -> button.click());
        Thread.sleep(5000);

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String newWindow : allWindows) {
            driver.switchTo().window(newWindow);
            System.out.println(driver.getTitle());

            switch (driver.getTitle()){
                case "AMC Theatres (amctheatres) - Profile | Pinterest":
                    System.out.println(driver.findElement(By.xpath("(//span[@class='tBJ dyH iFc yTZ pBj zDA mWe'])[1]")).getText()+ " Followers");
                    System.out.println(driver.findElement(By.xpath("(//span[@class='tBJ dyH iFc yTZ pBj zDA mWe'])[2]")).getText() + " Following");
                    break;
                case "Login • Instagram":
                    System.out.println(driver.findElement(By.xpath("//h1")).getText());
                    break;
                case "AMC Theatres - YouTube":
                    System.out.println(driver.findElement(By.xpath("//yt-formatted-string[@id='subscriber-count']")).getText());
                    break;
                case "AMC Theatres (@AMCTheatres) / Twitter":
                    System.out.println(driver.findElement(By.xpath("//a[@href='/AMCTheatres/following']/span[1]")).getText()+ " Following");
                    System.out.println(driver.findElement(By.xpath("//a[@href='/AMCTheatres/followers']/span[1]")).getText() + " Followers");
                    break;
                case "AMC Theatres - Home | Facebook":
                    System.out.println(driver.findElement(By.xpath("//div[@class='clearfix _ikh']/div[@class='_4bl9']")).getText());
                    System.out.println(driver.findElement(By.xpath("(//div[@class='_4bl9'])[3]")).getText());
                    break;
                default:
                    System.out.println("Title didn't match!");
            }

            System.out.println("----------");
            Thread.sleep(3000);
        }

        driver.switchTo().window(mainWindow);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[@class='Showtimes-label']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys(String.valueOf(22015));
        driver.findElement(By.xpath("//div[@class='search-buttons']")).click();
        Thread.sleep(2000);

        List<WebElement> location = driver.findElements(By.xpath("//div[@class='theatre-result__headline']"));
        location.forEach(locationName -> System.out.println(locationName.getText()));
        System.out.println("----------");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//i[@class='icon icon_close']")).click();
        driver.findElement(By.xpath("//i[@class='icon_close']")).click();

        System.out.println(driver.findElement(By.xpath("//p[text()='Closing this window will cancel your order.  Are you sure?']")).getText());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='Btn Btn--Secondary']")).click();

        driver.quit();



    }
}

