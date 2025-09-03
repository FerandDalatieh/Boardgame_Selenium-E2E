package pages;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void failedLogin(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername("wrongUserName");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickLoginButton();
        String actualErrorMessage = loginPage.getFaildLoginMessage();
        String expectedErrorMessage = "Invalid User Name or Password";

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Test
    public void succesfullUserLogin(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername("bugs");
        loginPage.enterPassword("bunny");
        loginPage.clickLoginButton();
        UserPage userPage = new UserPage();
        String actualTitle = userPage.getTitleText();
        String expectedTitle = "You are successfully logged in";

        Assert.assertEquals(actualTitle, expectedTitle);

        String actualRoles = userPage.getRoles();
        String expectedRoles = "[ROLE_USER]";

        Assert.assertEquals(actualRoles, expectedRoles);

        userPage.goToLogout();
    }


    @Test
    public void succesfullManagerLogin(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername("daffy");
        loginPage.enterPassword("duck");
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        String actualTitle = managerPage.getTitleText();
        String expectedTitle = "You are successfully logged in";

        Assert.assertEquals(actualTitle, expectedTitle);

        String actualRoles = managerPage.getRoles();
        String expectedRoles = "[ROLE_MANAGER, ROLE_USER]";

        Assert.assertEquals(actualRoles, expectedRoles);

        managerPage.goToLogout();
    }

    @Test(dependsOnMethods = {"successfullManagerSignup"})
    public void succesfullManagerLoginAfterSignup(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername(homePage.usernameManager);
        loginPage.enterPassword("pa$$word");
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        String actualTitle = managerPage.getTitleText();
        String expectedTitle = "You are successfully logged in";

        Assert.assertEquals(actualTitle, expectedTitle);

        managerPage.goToLogout();
    }

    @Test(dependsOnMethods = {"successfullUserSignup"})
    public void succesfullUserLoginAfterSignup(){
        LoginPage loginPage = homePage.goToLogin();
        loginPage.enterUsername(homePage.usernameUser);
        loginPage.enterPassword("pa$$word");
        loginPage.clickLoginButton();
        ManagerPage managerPage = new ManagerPage();
        String actualTitle = managerPage.getTitleText();
        String expectedTitle = "You are successfully logged in";

        Assert.assertEquals(actualTitle, expectedTitle);

        managerPage.goToLogout();
    }

}
