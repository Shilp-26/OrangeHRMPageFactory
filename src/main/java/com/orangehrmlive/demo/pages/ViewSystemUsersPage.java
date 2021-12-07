package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsersPage extends Utility {

    public ViewSystemUsersPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'System Users')]")
    WebElement systemUserTxt;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminLink;

    @FindBy(id = "btnAdd")
    WebElement addBtn;

    @FindBy(xpath = "//div[contains(text(),'Successfully Saved')]")
    WebElement successfullySavedText;

    @FindBy(id = "searchSystemUser_userName")
    WebElement searchUserName;

    @FindBy(id = "searchSystemUser_userType")
    WebElement searchUserRole;

    @FindBy(id = "searchSystemUser_status")
    WebElement searchUserStatus;

    @FindBy(id = "searchBtn")
    WebElement searchBtn;

    @FindBy(xpath = "//a[contains(text(),'Ananya9')]")
    WebElement verifyResultList;

    @FindBy(xpath = "//input[@id='ohrmList_chkSelectAll']")
    WebElement checkBox;

    @FindBy(id = "btnDelete")
    WebElement deleteButton;

    @FindBy(id = "dialogDeleteBtn")
    WebElement deleteRecordPopUp;

    @FindBy(xpath = "//div[contains(text(),'Successfully Deleted')]")
    WebElement successFullyDeletedText;

    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFoundText;


    public void verifySystemUsersText(String text){
        verifyThatTextIsDisplayed(systemUserTxt, text);
        CustomListeners.test.log(Status.PASS,"Verify System User text " + text);
    }

    public void clickOnAdminTab(){
        clickOnElement(adminLink);
        CustomListeners.test.log(Status.PASS,"Click on Admin Tab ");
    }

    public void clickAddButton(){
        clickOnElement(addBtn);
        CustomListeners.test.log(Status.PASS,"Click on withdraw button ");
    }

    public void verifySuccessfullySavedMessage(String text) throws InterruptedException {
        Thread.sleep(2000);
        verifyThatTextIsDisplayed(successfullySavedText, text);
        CustomListeners.test.log(Status.PASS,"Verify Successfully Saved Message displayed " + text);
    }

    public void clickOnSearchButton(){
        clickOnElement(searchBtn);
        CustomListeners.test.log(Status.PASS,"Click on searchBtn");
    }

    public void inputUserName(String userName){
        sendTextToElement(searchUserName, userName);
        CustomListeners.test.log(Status.PASS,"Enter username " +userName);
    }

    public void selectUserRole(String role){
        selectByVisibleTextFromDropDown(searchUserRole, role);
        CustomListeners.test.log(Status.PASS,"Select user role from dropdown " + role);
    }

    public void selectUserStatus(String status){
        selectByVisibleTextFromDropDown(searchUserStatus, status);
        CustomListeners.test.log(Status.PASS,"Select user status " + status);
    }

    public void verifyUserInSearchResult(String userName){
        verifyThatTextIsDisplayed(verifyResultList, userName);
        CustomListeners.test.log(Status.PASS,"Enter username " + userName);
    }

    public void clickOnCheckBox(){
        clickOnElement(checkBox);
        CustomListeners.test.log(Status.PASS,"Click on checkBox ");
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
        CustomListeners.test.log(Status.PASS,"Click on deleteButton");
    }

    public void acceptPopUpMessage(){
        clickOnElement(deleteRecordPopUp);
        CustomListeners.test.log(Status.PASS,"Accept popup ");
    }

    public void verifyRecordSuccessfullyDeletedMessage(String message){
        verifyThatTextIsDisplayed(successFullyDeletedText, message);
        CustomListeners.test.log(Status.PASS,"Verify message "+message);
    }

    public void verifyNoRecordFoundText(String message){
        verifyThatTextIsDisplayed(noRecordFoundText, message);
        CustomListeners.test.log(Status.PASS,"Verify message "+message);
    }

}
