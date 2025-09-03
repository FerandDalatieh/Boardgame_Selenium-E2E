package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameInput = By.xpath("//input[@id=\"inputUserName\"]");
    private final By passwordInput = By.xpath("//input[@id=\"inputPassword\"]");
    private final By loginInput = By.xpath("//input[@value=\"Log In\"]");
    private final By faildLoginMessage = By.xpath("//*[text()=\"Invalid User Name or Password\"]");
    private final By succesfullLogoutMessage = By.xpath("//*[text()=\"You are now logged out\"]");


    public final void enterUsername(String text){
        clearText(usernameInput);
        enterText(usernameInput, text);
    }

    public final void enterPassword(String text){
        clearText(passwordInput);
        enterText(passwordInput, text);
    }

    public final void clickLoginButton(){
        click(loginInput);
    }

    public final UserPage userLogin(){
        enterUsername("bugs");
        enterPassword("bunny");
        clickLoginButton();
        return new UserPage();
    }

    public final ManagerPage managerLogin(){
        enterUsername("daffy");
        enterPassword("duck");
        clickLoginButton();
        return new ManagerPage();
    }

    public final String getFaildLoginMessage(){
        return getText(faildLoginMessage);
    }

    public final String getSuccesfullLogoutMessage(){
        return getText(succesfullLogoutMessage);
    }
}
