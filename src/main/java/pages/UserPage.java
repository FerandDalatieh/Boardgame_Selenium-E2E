package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class UserPage extends BasePage {

    private By roles = By.xpath("//span[contains(text(),\"[ROLE\")]");

    public String getRoles(){
        return getText(roles);
    }
}
