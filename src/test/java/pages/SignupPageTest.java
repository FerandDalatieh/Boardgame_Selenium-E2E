package pages;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utilities;

public class SignupPageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void failedSignup (){
        SignupPage signupPage = homePage.goToSignup();

        signupPage.clickSignupButton();
        String actualErrorMessage = signupPage.getMissingInfoErrorMessage();
        String expectedErrorMessage = "User name and password are required";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        signupPage.enterUsername("user");
        signupPage.clickSignupButton();
        actualErrorMessage = signupPage.getMissingInfoErrorMessage();

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        signupPage.enterPassword(BasePage.password);
        signupPage.clickSignupButton();
        actualErrorMessage = signupPage.getMissingInfoErrorMessage();
        expectedErrorMessage = "You must select at least one role";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);


        signupPage.selectManagerBox();
        signupPage.unselectUserCheckbox();
        signupPage.clickSignupButton();
        actualErrorMessage = signupPage.getMissingInfoErrorMessage();
        expectedErrorMessage = "To add a manager role, you should ALSO check a user role";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

    }

    @Test
    public void successfullManagerSignup(){

        SignupPage signupPage = homePage.goToSignup();

        String timeStamp = Utilities.timeStamp();
        String userName = "Manager " + timeStamp;

        signupPage.enterUsername(userName);
        signupPage.enterPassword(BasePage.password);
        signupPage.selectManagerBox();
        signupPage.clickSignupButton();

        String actualSuccesfullSignupMessage = homePage.getSuccesfullSignupMessage();
        String expectedSuccesfullSignupMessage = "User succesfully added!";

        Assert.assertEquals(actualSuccesfullSignupMessage, expectedSuccesfullSignupMessage);

        signupPage.setUsernameManager(userName);
    }

    @Test
    public void successfullUserSignup(){

        SignupPage signupPage = homePage.goToSignup();

        String timeStamp = Utilities.timeStamp();
        String userName = "User " + timeStamp;

        signupPage.enterUsername(userName);
        signupPage.enterPassword(BasePage.password);
        signupPage.selectUserBox();
        signupPage.clickSignupButton();

        String actualSuccesfullSignupMessage = homePage.getSuccesfullSignupMessage();
        String expectedSuccesfullSignupMessage = "User succesfully added!";

        Assert.assertEquals(actualSuccesfullSignupMessage, expectedSuccesfullSignupMessage);

        signupPage.setUsernameUser(userName);
    }
}