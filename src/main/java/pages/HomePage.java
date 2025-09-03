package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private final By addNewGame = By.xpath("//a[contains(@href, 'addBoardGame')]");

    private final By goToLoginLink = By.xpath("//a[@href=\"/login\"][text()=\"Here\"]");
    private final By goToSignupLink = By.xpath("//a[@href=\"/newUser\"][text()=\"Click\"]");
    private final By goToLogoutButton = By.xpath("//main//input[@type=\"submit\"][@value=\"Logout\"]");
    private final By succesfullSignupMessage = By.xpath("//*[text()=\"User succesfully added!\"]");
    private final By gamesList = By.xpath("//h4");


    private By nthGameXpath(int n){
        String xpathExpression = "//a[@href=\"/" + n + "\"]";
        return By.xpath(xpathExpression);
    }


    public final GamePage goToNthGame(int n){
        click(nthGameXpath(n));
        return new GamePage();
    }

    public final AddBoardGamePage goToAddNewGame(){
        click(addNewGame);
        return new AddBoardGamePage();
    }

    public final LoginPage clickOnLogout(){
        click(goToLogoutButton);
        return new LoginPage();
    }

    public final String getSuccesfullSignupMessage(){
        return getText(succesfullSignupMessage);
    }

    public final List<String> getGameNames(){
        List<WebElement> gamesWebElements = findElements(gamesList);
        List<String> output = new ArrayList<>();
        for(WebElement element : gamesWebElements){
            output.add(element.getText());
        }
        return output;
    }

}
