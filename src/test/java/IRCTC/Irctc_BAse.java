package IRCTC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Irctc_BAse {

    private String source_Station="Akola";
    private String destinationStation="Pune";
    private String  travelDate="10/05/2024";


    private WebDriver driver;
    private String Url="https://www.irctc.co.in/nget/train-search";
    private By sourceElement= By.xpath("//*[contains(@class,'ng-tns-c57-8 ui-autocomplete ui-widget') ]/input[@aria-controls='pr_id_1_list']");
    private By destinationElement= By.xpath("//*[contains(@class,'form-group ng-tns-c57-9 ng-pristine ng-invalid ng-touched') ]/span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']");
    private By selectDAteElement= By.id("jDate");
    private By searchButtonElement=By.xpath("//button[@type='submit']");

    public void driverInitialization(){
        driver= WebDriverManager.chromedriver().create();
    }
    public void getUrlmethod(){
        driver.get(Url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Url);

    }
//    public void alertMethod(){
//        driver.switchTo().alert().dismiss();
//    }

    public void giveSourceStation(){
        driver.findElement(sourceElement).sendKeys(source_Station);
    }
    public void giveDestinationStation(){
        driver.findElement(destinationElement).sendKeys();
    }
    public void selectDate(){
        driver.findElement(selectDAteElement).sendKeys(travelDate);
    }
    public void chooseClass(){
        WebElement classElement= driver.findElement(By.xpath("//*[@class='ng-tns-c65-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']"));
        Select sc= new Select(classElement);
        sc.selectByValue("Anubhuti Class (EA)");
    }
    public void clickSearchButton(){
        driver.findElement(searchButtonElement).click();
    }

    public static void main(String[] args) {
        Irctc_BAse obj=new Irctc_BAse();
        obj.driverInitialization();
        obj.getUrlmethod();
        obj.giveDestinationStation();
        obj.giveSourceStation();
        obj.selectDate();
        obj.chooseClass();
        obj.clickSearchButton();

    }
}
