package visiblityTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductCategoryVisiblityTest {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browser) {

        //If the browser is Firefox, then do this

        if (browser.equalsIgnoreCase("firefox")) {

            //Initializing the firefox driver (Gecko)
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {

            //Initialize the chrome driver

            driver = new ChromeDriver();


        } else if (browser.equalsIgnoreCase("edge")) {

            //Initialize the edge browser

            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/?ref=hackernoon.com");
    }

    @Test
    public void homePageTabsTest(){

        WebElement Whats_new_Tab= driver.findElement(By.xpath("//*[@id='ui-id-3']"));
        WebElement Women_Tab= driver.findElement(By.xpath("//*[text()='Women']"));
        WebElement Men_Tab= driver.findElement(By.xpath("//*[text()='Men']"));
        WebElement Gear_Tab= driver.findElement(By.xpath("//*[text()='Gear']"));
        WebElement Training_Tab= driver.findElement(By.xpath("//*[text()='Training']"));
        WebElement Sale_Tab= driver.findElement(By.xpath("//*[text()='Sale']"));

        if (Whats_new_Tab.isDisplayed()){
            System.out.println("What's New category is displayed on HomePage");
        }
        else {
            System.out.println("What's New category is not displayed on HomePage");
        }
        if (Women_Tab.isDisplayed()){
            System.out.println("Women category is displayed on HomePage");
        }
        else {
            System.out.println("Women category is not displayed on HomePage");
        }
        if (Men_Tab.isDisplayed()){
            System.out.println("Men Category is displayed on HomePage");
        }
        else {
            System.out.println("Men Category is not displayed on HomePage");
        }
        if (Gear_Tab.isDisplayed()){
            System.out.println("Gear Category is displayed on HomePage");
        }
        else {
            System.out.println("Gear Category is not displayed on HomePage");
        }
        if (Training_Tab.isDisplayed()){
            System.out.println("Training Category is displayed on HomePage");
        }
        else {
            System.out.println("Training Category is not displayed on HomePage");
        }
        if (Sale_Tab.isDisplayed()){
            System.out.println("Sale Category is displayed on HomePage");
        }
        else {
            System.out.println("Sale Category is not displayed on HomePage");
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
