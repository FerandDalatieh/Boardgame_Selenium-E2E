package pages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GamePageTest  extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void gameInfo(){
        homePage.goToHome();
        GamePage gamePage = homePage.goToNthGame(1);
        String actualTitleText = gamePage.getTitleText();
        String expectedTitleText = "Information of Splendor";

        Assert.assertEquals(actualTitleText, expectedTitleText);

        ReviewsListPage reviewsListPage = gamePage.goToReviewsList();

        String actualReviewsTitleText = reviewsListPage.getTitleText();
        String expectedReviewsTitleText = "User Reviews for Splendor";

        Assert.assertEquals(actualReviewsTitleText, expectedReviewsTitleText);

        gamePage.goToHome();

        homePage.goToNthGame(2);
        actualTitleText = gamePage.getTitleText();
        expectedTitleText = "Information of Clue";

        Assert.assertEquals(actualTitleText, expectedTitleText);

        String actualGameLevel = gamePage.getGameLevel();
        String expectedGameLevel = "Game Level: 2";

        Assert.assertEquals(actualGameLevel, expectedGameLevel);

        String actualPlayersCount = gamePage.getPlayersCount();
        String expectedPlayersCount = "Players: 1 - 6 people";

        Assert.assertEquals(actualPlayersCount, expectedPlayersCount);

        gamePage.goToHome();

        homePage.goToNthGame(3);
        actualTitleText = gamePage.getTitleText();
        expectedTitleText = "Information of Linkee";

        Assert.assertEquals(actualTitleText, expectedTitleText);

        String actualGameType = gamePage.getGameType();
        String expectedGameType = "Game Type: Trivia Game";

        Assert.assertEquals(actualGameType, expectedGameType);

        gamePage.goToHome();
    }
}
