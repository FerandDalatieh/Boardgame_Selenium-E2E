package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddBoardGamePage extends BasePage {

    private final By boardGameName = By.xpath("//input[@id=\"name\"]");
    private final By difficultySlider = By.xpath("//input[@id=\"myRange\"]");
    private final By minPlayersDropdown = By.xpath("//select[@id=\"minPlayers\"]");
    private final By maxPlayersDropdown = By.xpath("//select[@id=\"maxPlayers\"]");
    private final By gameTypeDropdown = By.xpath("//select[@id=\"gameType\"]");
    private final By submitButton = By.xpath("//input[@type=\"submit\"][contains(@value,\"Submit\")]");

    public enum AllowedGameTypes{
        PARTY("Party Game"),
        TRIVIA("Trivia Game"),
        STRATEGY("Strategy Game");

        private final String type;

        AllowedGameTypes(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    private void moveSliderRight(){
        find(difficultySlider).sendKeys(Keys.ARROW_RIGHT);
    }

    private void moveSliderLeft(){
        find(difficultySlider).sendKeys(Keys.ARROW_LEFT);
    }

    public final void setDifficultySlider(int difficulty){
        int maxDifficulty = 5;
        if(difficulty>maxDifficulty){
            throw new IllegalArgumentException("Difficulty cannot be over " + maxDifficulty + " !");
        }
        //resetting the slider to the far left
        for(int i=1; i<maxDifficulty; i++){
            moveSliderLeft();
        }
        for(int i=1; i<difficulty; i++){
            moveSliderRight();
        }
    }

    public final void enterGameName(String text){
        enterText(boardGameName, text);
    }

    public final void selectMinPlayersCount(String value){
        WebElement dropdownElement = find(minPlayersDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public final void selectMaxPlayersCount(String value){
        WebElement dropdownElement = find(maxPlayersDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public final void selectGameType(AllowedGameTypes type){
        WebElement dropdownElement = find(gameTypeDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(type.getType());
    }

    public final HomePage clickSubmitGame(){
        click(submitButton);
        return new HomePage();
    }
}
