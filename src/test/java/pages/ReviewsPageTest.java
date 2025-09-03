package pages;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utilities;

public class ReviewsPageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test(dependsOnMethods = {"successfullManagerSignup"})
    public void editReviewTest(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername(BasePage.usernameManager);
        loginPage.enterPassword(BasePage.password);
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        managerPage.goToHome();

        GamePage gamePage = homePage.goToNthGame(1);
        ReviewsListPage reviewsListPage = gamePage.goToReviewsList();
        String initialFirstReview = reviewsListPage.getTextNthReview(1);
        ReviewPage reviewPage = reviewsListPage.clickOnEditNthReview(1);
        String timeStamp = Utilities.timeStamp();

        reviewPage.appendReviewText(" " + timeStamp);
        reviewsListPage = reviewPage.submitReviewText();
        String actualFirstReview = reviewsListPage.getTextNthReview(1);
        String expectedFirstReview = initialFirstReview + " " + timeStamp;

        Assert.assertEquals(actualFirstReview, expectedFirstReview);

        int numberOfReviews = reviewsListPage.getNumberOfReviews();
        reviewPage = reviewsListPage.clickOnEditNthReview(numberOfReviews);
        timeStamp = Utilities.timeStamp();

        reviewPage.composeReviewText(timeStamp);
        reviewsListPage = reviewPage.submitReviewText();
        String actualSecondReview = reviewsListPage.getTextNthReview(numberOfReviews);
        String expectedSecondReview = timeStamp;

        Assert.assertEquals(actualSecondReview, expectedSecondReview);

        reviewsListPage.goToLogout();
    }

    @Test(dependsOnMethods = {"successfullManagerSignup"})
    public void addReviewTest(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername(BasePage.usernameManager);
        loginPage.enterPassword(BasePage.password);
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        managerPage.goToHome();

        GamePage gamePage = homePage.goToNthGame(1);
        ReviewsListPage reviewsListPage = gamePage.goToReviewsList();
        ReviewPage reviewPage = reviewsListPage.addRevview();
        String expectedAddedReviewText = Utilities.timeStamp();
        reviewPage.composeReviewText(expectedAddedReviewText);
        reviewPage.submitReviewText();
        int numberOfReviews = reviewsListPage.getNumberOfReviews();
        String actualAddedReviewText = reviewsListPage.getTextNthReview(numberOfReviews);

        Assert.assertEquals(actualAddedReviewText, expectedAddedReviewText);

        reviewsListPage.goToLogout();
    }


    @Test(dependsOnMethods = {"successfullManagerSignup", "addReviewTest"})
    public void deleteReviewTest(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername(BasePage.usernameManager);
        loginPage.enterPassword(BasePage.password);
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        managerPage.goToHome();

        GamePage gamePage = homePage.goToNthGame(1);
        ReviewsListPage reviewsListPage = gamePage.goToReviewsList();
        int initialReviewNumber = reviewsListPage.getNumberOfReviews();
        reviewsListPage.clickOnDeletethReview(initialReviewNumber);
        int changedReviewNumber = reviewsListPage.getNumberOfReviews();

        Assert.assertEquals(changedReviewNumber, initialReviewNumber-1);

        reviewsListPage.goToLogout();
    }

}
