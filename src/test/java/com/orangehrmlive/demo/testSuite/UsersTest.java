package com.orangehrmlive.demo.testSuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class UsersTest extends TestBase {
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

    @Test ( groups = {"smoke", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        loginPage.loginToApplicaiton("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.clickAddButton();
        addUserPage.verifyAddUserText("Add User");
        addUserPage.addUserDetails("Admin", "Ananya Dash","Ananya9",
                "Disabled", "Ananya26","Ananya1997");
        addUserPage.clickOnSaveButton();
        viewSystemUsersPage.verifySuccessfullySavedMessage("Successfully Saved");
    }

    @Test (groups = {"sanity", "regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginPage.loginToApplicaiton("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.inputUserName("Ananya26");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        viewSystemUsersPage.verifyUserInSearchResult("Ananya26");
    }

    @Test (groups = {"sanity", "regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        searchTheUserCreatedAndVerifyIt();
        viewSystemUsersPage.clickOnCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.acceptPopUpMessage();
        viewSystemUsersPage.verifyRecordSuccessfullyDeletedMessage("Successfully Deleted");
    }

    @Test (groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(){
        loginPage.loginToApplicaiton("Admin", "admin123");
        viewSystemUsersPage.clickOnAdminTab();
        viewSystemUsersPage.verifySystemUsersText("System Users");
        viewSystemUsersPage.inputUserName("Ananya26");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectUserStatus("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        viewSystemUsersPage.verifyNoRecordFoundText("No Records Found");
    }


}
