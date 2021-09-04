import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class day15syncHW {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.orbitz.com/");
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);

        driver.findElement(By.xpath("//button[@class='uitk-faux-input']")).click();
        driver.findElement(By.id("location-field-destination")).sendKeys("Las Vegas");
        driver.findElement(By.id("location-field-destination")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("d1-btn")).click();
        driver.findElement(By.xpath("(//button[@data-stid='date-picker-paging'])[1]")).click();

//        Storing check in and check out date

        LocalDate today = LocalDate.now();
        LocalDate after2weeks = today.plusWeeks(2);

        DateTimeFormatter current = DateTimeFormatter.ofPattern("MMM dd, YYYY");

        String curDate= current.format(today);
        String after2week = current.format(after2weeks);

//        Entering required information to search the Hotel

        driver.findElement(By.xpath("//button[@aria-label='"+curDate+"']")).click();
        driver.findElement(By.xpath("//button[@aria-label='"+after2week+"']")).click();
        driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();

        driver.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']")).click();
        driver.findElement(By.xpath("(//button[@class='uitk-flex-item uitk-step-input-button'])[4]")).click();
        driver.findElement(By.xpath("(//button[@class='uitk-flex-item uitk-step-input-button'])[4]")).click();

        WebElement sel = driver.findElement(By.id("child-age-input-0-0"));

        Select select = new Select(sel);
        select.selectByValue("2");

        WebElement sel1 = driver.findElement(By.id("child-age-input-0-1"));
        Select select1 = new Select(sel1);
        select1.selectByValue("4");
        System.out.println("Check in date :"+ curDate);
        System.out.println("Check out date :"+after2week);
        System.out.println("----------------------------");

        driver.findElement(By.xpath("//button[@data-testid='add-room-button']")).click();
        driver.findElement(By.xpath("(//button[@class='uitk-flex-item uitk-step-input-button'])[6]")).click();
        driver.findElement(By.xpath("//button[text()='Done']")).click();

        driver.findElement(By.xpath("//button[text()='Search']")).click();

//        Scrolling down to load more hotels

        WebElement bottom = driver.findElement(By.xpath("//a[@href='https://www.expediagroup.com']"));
        js.executeScript("arguments[0].scrollIntoView(true)", bottom);

//        Printing out all Hotel name displayed

        System.out.println("Displayed hotel names");
        System.out.println(" ");

//        Creating the List with Hotel names

        List <WebElement> hotelNames = driver.findElements(By.xpath("//h3[@class='is-visually-hidden']"));
        hotelNames.forEach(name-> System.out.println(name.getText()));

//        Creating the List with Hotel names

        List <WebElement> rating = driver.findElements(By.xpath("//span[@data-stid='content-hotel-reviews-rating']"));

//        Creating the List with Hotel prices

        List <WebElement> price = driver.findElements(By.xpath("//span[@data-stid='price-lockup-text']"));

        System.out.println("----------------------------");
        System.out.println("Hotels with rating more than 4.5:");
        System.out.println("");

//        Storing all hotels with rating more than 4.5
//        Print them out

        Map <String, Double> hotelRating = new HashMap<>();
        for(int i=0; i<hotelNames.size(); i++) {
            if (Double.parseDouble(rating.get(i).getText().substring(0, 3)) > 4.5) {
                hotelRating.put(hotelNames.get(i).getText(),
                        Double.parseDouble(rating.get(i).getText().substring(0, 3)));
            }
        }
       for (String key: hotelRating.keySet()){
           System.out.println(key + " | Hotel rating: " + hotelRating.get(key));
       }

        System.out.println("----------------------------");
        System.out.println("Hotels with price more than $100");
        System.out.println("");

//        Storing all hotels with price more than $100
//        Print them out

        Map <String, Integer> hotelPrice = new HashMap<>();
        for(int i=0; i<hotelNames.size(); i++) {
            if (Integer.parseInt(price.get(i).getText().substring(1))>100){
                hotelPrice.put(hotelNames.get(i).getText(),
                        Integer.parseInt(price.get(i).getText().substring(1)));
            }
        }
        for (String key1: hotelPrice.keySet()){
            System.out.println(key1 + " | Hotel price: " + hotelPrice.get(key1));
        }

//        Storing all hotels with dicount more than 20%
//        Print them out

        System.out.println("----------------------------");
        System.out.println("Hotels has with discount over 20%");
        System.out.println("");
        List <WebElement> hotelsDiscount = driver.findElements(By.xpath("//span[@class='uitk-badge-text']" +
                "[contains(text(),'% off')]/ancestor::div[@class='uitk-flex uitk-flex-column']/div/h3"));
        List <WebElement> discount = driver.findElements(By.xpath("//span[@class='uitk-badge-text'][contains(text(),'% off')]"));


        Map <String, Integer> hotelDisc = new HashMap<>();
        for (int i=0; i<hotelsDiscount.size(); i++){
            if ((Integer.parseInt(discount.get(i).getText().replaceAll("[^\\d]","")) % 100) > 20) {
                hotelDisc.put(hotelsDiscount.get(i).getText(), (Integer.parseInt(discount.get(i).getText().replaceAll("[^\\d]","")))%100);
            }

        }
        for (String key2: hotelDisc.keySet()){
            System.out.println(key2 + " | Hotel discount: " + hotelDisc.get(key2));
        }

//        Creating the Lists of 1.hotels with rating more than 4.5
//                              2.hotels with price more than $100
//                              3.hotels with dicount more than 20%

        List <String> rating1 = new ArrayList<>(hotelRating.keySet());
        List <String> price1 = new ArrayList<>(hotelPrice.keySet());
        List <String> discount1 = new ArrayList<>(hotelDisc.keySet());

//        Comparing the lists to find if there is a Hotel which has dicount over 20%, price above $100 and rating above 4.5

        System.out.println("----------------------------");
        System.out.println("Hotels has dicount over 20%, price above $100, rating above 4.5");
        System.out.println("");
        discount1.retainAll(price1);
        discount1.retainAll(rating1);

//        Print out hotels which meet the requirements

        if (discount1.size()<1){
            System.out.println("There is no hotels with meet the requirements");
        }
        discount1.forEach(name -> System.out.println(name));

        driver.close();
    }
}

