package User_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utitlities.LogIN_User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class User_LogIN {

    String email_Xpath=new LogIN_User().email;
    String password_Xpath=new LogIN_User().password;
    String logINButton_Xpath=new LogIN_User().logInButton;

    Properties value= new Properties();
    FileInputStream inputStream=new FileInputStream("D:\\Project_Directory\\Sojern_PF\\src\\main\\java\\important files\\user_Data.properties");

    public User_LogIN() throws IOException {
    }
    public WebDriver driver;
    String email=new User_CR1().email;

    @BeforeTest
    public void setUP(){
        driver=WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8_cmVmPWhhY2tlcm5vb24uY29t/");
    }

    @Test
    public void logINTEst() throws IOException {
        value.load(inputStream);

        WebElement enter_EmailID=driver.findElement(By.xpath(email_Xpath));
                   enter_EmailID.sendKeys(email);

        WebElement enter_Password=driver.findElement(By.xpath(password_Xpath));
                   enter_Password.sendKeys(value.getProperty("Password"));

        WebElement click_SignIN_Button= driver.findElement(By.xpath(logINButton_Xpath));
                   click_SignIN_Button.click();



        System.out.println("Successfully Loged In");
        System.out.println(email);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
