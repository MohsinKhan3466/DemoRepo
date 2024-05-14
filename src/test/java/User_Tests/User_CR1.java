package User_Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utitlities.Create_User;
import utitlities.EmailGenerator;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class User_CR1 {

    String first_Name_xpath=new Create_User().first_Name;
    String last_Name_xpath=new Create_User().last_Name;
    String email_ID_xpath=new Create_User().email_Id;
    String password_xpath=new Create_User().password;
    String confirm_pass_xpath=new Create_User().confirm_Password;
    String create_UserButton_xpath=new Create_User().create_An_Account;
    String successMessage_Xpath=new Create_User().successMessage;
    String expectedMessage=new Create_User().expected_Message;
    public User_CR1() throws IOException {
        value.load(inputStream);
        value.load(is);
    }
    Properties value= new Properties();

    FileInputStream inputStream=new FileInputStream("D:\\Project_Directory\\Sojern_PF\\src\\main\\java\\important files\\Important_Links.properties");
    FileInputStream is=new FileInputStream("D:\\Project_Directory\\Sojern_PF\\src\\main\\java\\important files\\user_Data.properties");

   public String email= EmailGenerator.emailGenerator();

       public  WebDriver driver;


        @BeforeClass
        public void setUp() {

            driver= WebDriverManager.chromedriver().create();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(value.getProperty("URL"));

    }
    @Test
    public void test_correct_application() throws IOException {

        String expected_Title= value.getProperty("Title");
        String actual_Title=driver.getTitle();

       if (expected_Title==actual_Title){
           System.out.println("Landed on LUMA Page Safely");

           System.out.println("expected URL:"+expected_Title);
           System.out.println("actual URL:"+actual_Title);

       }
       else {
           System.out.println("Caution: Please check the URL");
       }

    }

    @Test
    public void createAnAccount() throws IOException {
    driver.get(value.getProperty("CreateAccountURL"));

        WebElement first_Name= driver.findElement(By.xpath(first_Name_xpath));
                   first_Name.sendKeys(value.getProperty("First_Name"));

        WebElement last_Name= driver.findElement(By.xpath(last_Name_xpath));
                   last_Name.sendKeys(value.getProperty("Last_Name"));

        WebElement email_ID= driver.findElement(By.xpath(email_ID_xpath));
                   email_ID.sendKeys(email);

        WebElement password= driver.findElement(By.xpath(password_xpath));
                   password.sendKeys(value.getProperty("Password"));

        WebElement confirm_Password= driver.findElement(By.xpath(confirm_pass_xpath));
                   confirm_Password.sendKeys(value.getProperty("Password"));

        WebElement create_Account= driver.findElement(By.xpath(create_UserButton_xpath));
                   create_Account.click();

        WebElement successMessage = driver.findElement(By.xpath(successMessage_Xpath));

        if (Objects.equals(expectedMessage, successMessage.getText())){
            System.out.println(successMessage.getText());

        }
        else {
            System.out.println("Please enter valid data");
        }
        }


   @AfterTest
    public void tearDown(){
            driver.quit();
    }
}

