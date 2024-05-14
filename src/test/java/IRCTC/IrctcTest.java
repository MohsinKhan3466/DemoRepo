package IRCTC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IrctcTest {

    public static void main(String[] args) {

        WebDriver driver;
        driver= WebDriverManager.chromedriver().create();

        driver.get("https://www.irctc.co.in/nget/booking/train-list");

        WebElement sourceStation= driver.findElement(By.xpath("//input[@role='searchbox']/following-sibling::div"));
        sourceStation.sendKeys("Nagpur");
    }
}
