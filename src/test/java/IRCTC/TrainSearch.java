package IRCTC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TrainSearch {

        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            driver= WebDriverManager.chromedriver().create();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }

        @DataProvider(name = "trainSearchData")
        public Object[][] testData() throws IOException {
            // Provide path to your Excel file
            String excelFilePath = "D:\\Project_Directory\\Sojern_PF\\src\\main\\java\\utitlities\\testData.xlsx";

            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet("TestData");

            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            Object[][] data = new Object[rowCount][3];

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                data[i - 1][0] = row.getCell(0).getStringCellValue(); // Departure station
                data[i - 1][1] = row.getCell(1).getStringCellValue(); // Arrival station
                data[i - 1][2] = row.getCell(2).getStringCellValue(); // Date of travel
                data[i - 1][3] = row.getCell(3).getStringCellValue();
            }

            workbook.close();
            inputStream.close();

            return data;
        }

        @Test(dataProvider = "trainSearchData")
        public void searchTrain(String departureStation, String arrivalStation, String travelDate) {
            // Navigate to train search page
            driver.get("https://www.irctc.co.in/nget/train-search");

            // Fill in search criteria
            WebElement departureInput = driver.findElement(By.id("departureStation"));
            departureInput.sendKeys(departureStation);

            WebElement arrivalInput = driver.findElement(By.id("arrivalStation"));
            arrivalInput.sendKeys(arrivalStation);

            WebElement dateInput = driver.findElement(By.id("travelDate"));
            dateInput.sendKeys(travelDate);

            // Submit the search
            WebElement searchButton = driver.findElement(By.id("searchButton"));
            searchButton.click();

            // Perform assertions or additional actions as needed
            // Example:
            // Assert.assertTrue(driver.getTitle().contains("Search Results"));
        }

        @AfterClass
        public void tearDown() {

                driver.quit();

        }


}
