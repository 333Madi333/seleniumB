import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class orbitz_HWshow {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;

        driver.get("https://orbitz.com");
        driver.findElement(By.xpath("//div[@class='uitk-field has-floatedLabel-label has-icon has-no-placeholder']")).click();
        driver.findElement(By.id("location-field-destination")).sendKeys("Las Vegas");
        driver.findElement(By.xpath("//div[@class='truncate']")).click();

        //Selecting dates
        driver.findElement(By.id("d1-btn")).click();

        //Getting current date and plus 2 weeks
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
        String currentDate = formatter.format(date);
        String futureDate = formatter.format(date.plusDays(14));

//        try{
//            driver.findElement(By.xpath("//button[@aria-label='" + currentDate + "']")).click();
//        } catch (NoSuchElementException e){
//            System.out.println("Exception was handled");
//            driver.findElement(By.xpath("//button[@data-stid='date-picker-paging']")).click();
//            driver.findElement(By.xpath("//button[@aria-label='" + currentDate + "']")).click();
//        }

        driver.findElement(By.xpath("//button[@data-stid='date-picker-paging']")).click();
        driver.findElement(By.xpath("//button[@aria-label='" + currentDate + "']")).click();

        driver.findElement(By.xpath("//button[@aria-label='" + futureDate + "']")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        //Selecting rooms
        driver.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']")).click();
        driver.findElement(By.xpath("(//button[@class='uitk-flex-item uitk-step-input-button'])[4]")).click();
        driver.findElement(By.xpath("(//button[@class='uitk-flex-item uitk-step-input-button'])[4]")).click();

        //selecting child ages
        Select select1 = new Select(driver.findElement(By.id("child-age-input-0-0")));
        select1.selectByVisibleText("2");

        Select select2 = new Select(driver.findElement(By.id("child-age-input-0-1")));
        select2.selectByVisibleText("4");

        driver.findElement(By.xpath("//*[text()='Add another room']")).click();
        driver.findElement(By.xpath("(//button[@class='uitk-flex-item uitk-step-input-button'])[6]")).click();
        driver.findElement(By.xpath("//button[@data-testid='guests-done-button']")).click();

        //clicking Search button
        driver.findElement(By.xpath("//*[text()='Search']")).click();

        //moving to the bottom of the page
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//footer")));

        //capturing and printing out all hotel names
        List<WebElement> hotels = driver.findElements(By.xpath("//section[@class='results']//div[starts-with(@class,'uitk-layout-grid')]/h3"));
//        hotels.forEach(each -> System.out.println(each.getText()));

        Map<String, Integer> price = new HashMap<>();
        Map<String, Double> rating = new HashMap<>();
        Map<String, Integer> discount = new HashMap<>();

        List<WebElement> allItems = driver.findElements(By.xpath("//ol/li[contains(@class, 'horizontal')]"));

        for(int i=0; i < allItems.size(); i++){
            //name of the hotel
            String hotelName = allItems.get(i).findElement(By.xpath(".//div[starts-with(@class,'uitk-layout-grid')]/h3")).getText();

            //price of the hotel
            String tempPrice = allItems.get(i).findElement(By.xpath(".//span[@data-stid='price-lockup-text']")).getText();
            int actualPrice = Integer.parseInt(tempPrice.substring(1));

            //rating of the hotel
            String tempRating = allItems.get(i).findElement(By.xpath(".//span[@data-stid='content-hotel-reviews-rating']")).getText();
            double actualRating = Double.parseDouble(tempRating.substring(0, tempRating.indexOf("/")).replace(",",""));

            List<WebElement> d1 = allItems.get(i).findElements(By.xpath(".//span[contains(text(), '%')]"));

            int actualDiscount = 0;
            if (d1.size() > 0) {
                String tempDiscount = d1.get(0).getText();
                actualDiscount = Integer.parseInt(tempDiscount.substring(tempDiscount.indexOf("%") - 2, tempDiscount.indexOf("%")).trim());
            }

            //storing in the map
            if (actualPrice > 100)
                price.put(hotelName, actualPrice);
            if (actualDiscount >= 20)
                discount.put(hotelName, actualDiscount);
            if (actualRating >= 4.5)
                rating.put(hotelName, actualRating);
        }

        driver.close();
    }
}

