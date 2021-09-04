import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class day03_task {
    public static void main(String[] args) throws InterruptedException {
        task1();
        task2();
        task3();
    }

    static void task1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/home");

        driver.findElement(By.linkText("Inputs")).click();
        driver.findElement(By.id("message")).sendKeys("Madi");
        driver.findElement(By.name("button1")).click();

        String expectedText = "Madi";

        String actualText = driver.findElement(By.name("message1")).getText();

        System.out.println("Test if message is correct: " + expectedText.equals(actualText));

        driver.close();

    }

    static void task2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/inputs");

        int num = 5;
        int num1 = 7;
        int total = num + num1;

        String snum = String.valueOf(num);
        String snum1 = String.valueOf(num1);
        String expected = String.valueOf(total);


        driver.findElement(By.id("a")).sendKeys(snum);
        driver.findElement(By.id("b")).sendKeys(snum1);
        driver.findElement(By.name("button2")).click();

        String actual = driver.findElement(By.name("answer2")).getText();

        System.out.println("Is result is correct: " + expected.equals(actual));

        driver.close();

    }

    static void task3() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/inputs");
        driver.findElement(By.name("first_name")).sendKeys("Madi");
        driver.findElement(By.name("last_name")).sendKeys("Makhmutov");
        driver.findElement(By.name("email")).sendKeys("333madi333@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("6466203036");
        driver.findElement(By.name("address")).sendKeys("101 main st");
        driver.findElement(By.name("city")).sendKeys("Canton");
        driver.findElement(By.name("zip")).sendKeys("48188");
        driver.findElement(By.name("state")).click();
        // select from pop-up menu
        Select objSelect = new Select(driver.findElement(By.name("state")));
        objSelect.selectByVisibleText("Michigan");

        driver.findElement(By.name("button3")).click();

        System.out.println("If it passed: " + driver.findElement(By.name("button3")).isDisplayed());

        driver.close();
    }

}
