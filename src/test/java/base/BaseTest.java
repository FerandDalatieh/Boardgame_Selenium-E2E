package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTest {

    //assuming that the app runs locally and not hosted somewhere yet
    public final String appUrl = "http://localhost:8080/";
    public WebDriver driver;




    @BeforeTest
    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        /* apparently incognito is more reliable
        because otherwise a popup from password manager blocks the UI after login */
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(appUrl);

        BasePage basePage = new BasePage();
        basePage.setDriver(driver);

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
