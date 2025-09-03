package pages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void homePageTest(){

        homePage.goToHome();
        String actualTitleText = homePage.getTitleText();
        String expectedTitleText = "Boardgame Lists";
        Assert.assertEquals(actualTitleText, expectedTitleText);
    }

}
