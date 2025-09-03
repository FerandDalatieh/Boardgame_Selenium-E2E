package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private static WebDriver driver;

    private final By pageTitle = By.xpath("//h1");
    private final By homeHeaderLink = By.xpath("//a[@href=\"/\"][text()=\"Home\"]");
    private final By loginHeaderLink = By.xpath("//a[@href=\"/login\"][text()=\"Login\"]");
    private final By signupHeaderLink = By.xpath("//a[@href=\"/newUser\"][text()=\"Sign-up\"]");
    private final By logoutInput = By.xpath("//input[@value=\"Logout\"]");

    private final int waitTimeOutInSeconds = 5;

    public static String usernameUser = "User";
    public static String usernameManager = "Manager";
    public static String password = "pa$$word";

    public final void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected final WebElement find(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeOutInSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    protected final List<WebElement> findElements (By locator){
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    protected final void click(By locator){
        find(locator).click();
    }

    public final String getTitleText(){
        return getText(pageTitle);
    }

    protected final void enterText(By locator, String text){
        find(locator).sendKeys(text);
    }

    protected final String getText(By locator){
        return find(locator).getText();
    }

    protected final void clearText(By locator){
        find(locator).clear();
    }

    public final LoginPage goToLogin(){
        click(loginHeaderLink);
        return new LoginPage();
    }

    public final SignupPage goToSignup(){
        click(signupHeaderLink);
        return new SignupPage();
    }

    public final HomePage goToHome(){
        click(homeHeaderLink);
        return new HomePage();
    }

    public final LoginPage goToLogout(){
        click(logoutInput);
        return new LoginPage();
    }

    protected final void selectCheckbox(By locator){
        WebElement checkbox = find(locator);

        if (!checkbox.isSelected()) {
            checkbox.click(); // This will select it
        }
    }

    protected final void unselectCheckbox(By locator){
        WebElement checkbox = find(locator);

        if (checkbox.isSelected()) {
            checkbox.click(); // This will unselect it
        }
    }

    public void setUsernameUser(String text){
        BasePage.usernameUser = text;
    }

    public void setUsernameManager(String text){
        BasePage.usernameManager = text;
    }

    public void setPassword(String text){
        BasePage.password = text;
    }
}
