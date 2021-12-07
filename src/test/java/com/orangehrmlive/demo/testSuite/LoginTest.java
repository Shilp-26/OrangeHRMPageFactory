package com.orangehrmlive.demo.testSuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(groups = {"sanity", "smoke", "regression"})
    public void initialize(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }


    @Test (groups = {"smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully(){
        loginPage.loginToApplicaiton("Admin", "admin123");
        homePage.verifyWelcomeText("welcome");
    }

    @Test (priority = 1, groups = {"sanity", "regression"})
    public void VerifyThatTheLogoDisplayOnHomePage(){
        loginPage.loginToApplicaiton("Admin", "admin123");
        homePage.verifyOrangeHrmLogoIsVisible();
    }

    @Test (priority = 2, groups = {"regression"})
    public void VerifyUserShouldLogOutSuccessFully() throws InterruptedException {
        loginPage.loginToApplicaiton("Admin", "admin123");
        homePage.clickOnProfileLogo();
        homePage.clickOnLogout();

    }
}
