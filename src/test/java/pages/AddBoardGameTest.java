package pages;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utilities;

import java.util.List;

public class AddBoardGameTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test(dependsOnMethods = {"successfullManagerSignup"})
    public void addNewGame() {
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername(BasePage.usernameManager);
        loginPage.enterPassword(BasePage.password);
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        managerPage.goToHome();

        List<String> expectedGameList = homePage.getGameNames();

        AddBoardGamePage addBoardGamePage = homePage.goToAddNewGame();
        String expectedGameName = Utilities.timeStamp();
        addBoardGamePage.enterGameName(expectedGameName);
        int expecteddifficulty = 4;
        addBoardGamePage.setDifficultySlider(expecteddifficulty);
        String expectedMinPlayerCount = "3";
        addBoardGamePage.selectMinPlayersCount(expectedMinPlayerCount);
        String expectedMaxPlayerCount = "5";
        addBoardGamePage.selectMaxPlayersCount(expectedMaxPlayerCount);
        AddBoardGamePage.AllowedGameTypes expectedGameType = AddBoardGamePage.AllowedGameTypes.TRIVIA;
        addBoardGamePage.selectGameType(expectedGameType);

        addBoardGamePage.clickSubmitGame();

        expectedGameList.add(expectedGameName);
        List<String> actualGameList = homePage.getGameNames();

        Assert.assertEquals(actualGameList, expectedGameList);

        GamePage gamePage = homePage.goToNthGame(actualGameList.size());
        String actualGameTitle = gamePage.getTitleText();
        Assert.assertEquals(actualGameTitle, "Information of " + expectedGameName);

        String actualGameDifficulty = gamePage.getGameLevel();
        Assert.assertEquals(actualGameDifficulty, "Game Level: " + expecteddifficulty);

        String actualPlayerCount = gamePage.getPlayersCount();
        Assert.assertEquals(actualPlayerCount, "Players: " + expectedMinPlayerCount + " - " + expectedMaxPlayerCount + " people");

        String actualGameType = gamePage.getGameType();
        Assert.assertEquals(actualGameType, "Game Type: " + expectedGameType.getType());

        gamePage.goToLogout();
    }


}
