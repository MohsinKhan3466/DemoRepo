package utitlities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Create_User {

    public static WebDriver driver;


            public String first_Name = "//*[@id='firstname']";



    public String last_Name="//*[@id='lastname']";



    public String email_Id = "//*[@id='email_address']";



    public String password = "//*[@id='password']";



    public String confirm_Password ="//*[@id='password-confirmation']";



    public String create_An_Account = "//button[@title='Create an Account']//*[text()='Create an Account']";

    public String successMessage="//*[@data-bind='html: $parent.prepareMessageForHtml(message.text)']";


    public String expected_Message="Thank you for registering with Main Website Store.";

    }
