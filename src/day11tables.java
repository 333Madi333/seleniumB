import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class day11tables {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/tables");

        List<WebElement> gender  = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        List<WebElement> name  = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        for(int i=0; i< gender.size(); i++){
            if (gender.get(i).getText().equals("Male")){
                System.out.println(name.get(i).getText());
            }
        }

//        driver.get("http://automation.techleadacademy.io/#/tables");
//        List<WebElement> tr = driver.findElements(By.xpath("//tbody/tr"));
//
//        for (int i=0; i < tr.size(); i++){
//            if (tr.get(i).findElement(By.xpath(".//td[3]")).getText().equals("Male"))
//                System.out.println(tr.get(i).findElement(By.xpath(".//td[1]")).getText());
//        }


        driver.close();
    }
}

