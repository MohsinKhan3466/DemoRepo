package User_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePAGE {

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
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/?ref=hackernoon.com");


    }

    @Test
    public void testTitle(){
       // System.out.println(driver.getTitle());
        String expected_Title= "Home Page";
        String actual_Title= driver.getTitle();

        if (actual_Title.equalsIgnoreCase(expected_Title)){
            System.out.println("Title Matched");
        }
        else {
            System.out.println("Title doesn't Matched");
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
