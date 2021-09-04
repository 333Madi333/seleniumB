import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day09popup {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/popup");



        driver.findElement(By.xpath("//button[@class='btn btn-warning btn-lg']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='feet']")).sendKeys("5");
        driver.findElement(By.xpath("//input[@name='inch']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@name='weight']")).sendKeys("210");
        driver.findElement(By.id("calculate_btn")).click();
        Thread.sleep(2000);

        System.out.println("Your BMI is: " + driver.findElement(By.id("result_progress")).getText());
        double wght = Double.parseDouble(driver.findElement(By.id("result_progress")).getText());
        if (wght<18.5){
            System.out.println("Underweight");
        }else if (wght>=18.5 && wght< 25){
            System.out.println("Normal weight");
        }if (wght>=25 && wght < 30){
            System.out.println("Overweight");
        } if (wght>=30) {
            System.out.println("Obese");
        }

    }
}
