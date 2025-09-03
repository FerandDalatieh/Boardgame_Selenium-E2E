package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class GamePage extends BasePage {

    private final By reviewsLink = By.xpath("//a[contains(@href, 'reviews')]");
    private final By gameLevel = By.xpath("//div[contains(text(), 'Game Level:')]");
    private final By playersCount = By.xpath("//div[contains(text(), 'Players:')]");
    private final By gameType = By.xpath("//div[contains(text(), 'Game Type:')]");

    public final String getGameLevel(){
        return getText(gameLevel);
    }

    public final String getPlayersCount(){
        return getText(playersCount);
    }

    public final String getGameType(){
        return getText(gameType);
    }

    public final ReviewsListPage goToReviewsList(){
        click(reviewsLink);
        return new ReviewsListPage();
    }

}
