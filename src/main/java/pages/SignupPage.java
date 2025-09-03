package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class SignupPage extends BasePage {

    private final By usernameInput = By.xpath("//input[@id=\"inputUserName\"]");
    private final By passwordInput = By.xpath("//input[@id=\"inputPassword\"]");

    private final By managerCheckbox = By.xpath("//input[@id=\"ROLE_MANAGER\"]");
    private final By userCheckbox = By.xpath("//input[@id=\"ROLE_USER\"]");
    private final By signupButton = By.xpath("//input[@value=\"Add User\"]");
    private final By missingInfoErrorMessage = By.xpath("//div[@id=\"error\"]");
    private final By existedUserErrorMessage = By.xpath("//div[@id=\"error\"]/div/p");

    public final void enterUsername(String text){
        clearText(usernameInput);
        enterText(usernameInput, text);
    }

    public final void enterPassword(String text){
        clearText(passwordInput);
        enterText(passwordInput, text);
    }

    public final HomePage clickSignupButton(){
        click(signupButton);
        return new HomePage();
    }

    public final void selectManagerBox(){
        selectCheckbox(managerCheckbox);
    }

    public final void selectUserBox(){
        selectCheckbox(userCheckbox);
    }

    public final String getExistedUserErrorMessage(){
        return getText(existedUserErrorMessage);
    }

    public final String getMissingInfoErrorMessage(){
        return getText(missingInfoErrorMessage);
    }

    public final void unselectManagerCheckbox(){
        unselectCheckbox(managerCheckbox);
    }

    public final void unselectUserCheckbox(){
        unselectCheckbox(userCheckbox);
    }
}
