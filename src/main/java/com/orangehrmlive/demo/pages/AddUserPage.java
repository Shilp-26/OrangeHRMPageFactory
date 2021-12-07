package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends Utility {

    public AddUserPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Add User')]")
    WebElement addUserTxt;

    @FindBy(id = "systemUser_userType")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(id = "systemUser_userName")
    WebElement userName;

    @FindBy(id = "systemUser_status")
    WebElement status;

    @FindBy(id = "systemUser_password")
    WebElement password;

    @FindBy(id = "systemUser_confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='btnSave']")
    WebElement saveBtn;

    public void addUserDetails(String uRole, String ename, String uName,
                               String estatus, String passwd, String cpasswd){
        selectByVisibleTextFromDropDown(userRole, uRole);
        CustomListeners.test.log(Status.PASS,"Select User Role " + uRole);
        sendTextToElement(employeeName, ename);
        CustomListeners.test.log(Status.PASS,"Enter employee name " + ename);
        sendTextToElement(userName, uName);
        CustomListeners.test.log(Status.PASS,"Enter username " + uName);
        selectByVisibleTextFromDropDown(status, estatus);
        CustomListeners.test.log(Status.PASS,"Click on save button " + estatus);
        sendTextToElement(password, passwd);
        CustomListeners.test.log(Status.PASS,"Enter password " + passwd);
        sendTextToElement(confirmPassword, cpasswd);
        CustomListeners.test.log(Status.PASS,"Confirm password "+ cpasswd);
    }

    public void clickOnSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(saveBtn);
        CustomListeners.test.log(Status.PASS,"Click on saveBtn");
    }

    public void verifyAddUserText(String text){
        verifyThatTextIsDisplayed(addUserTxt, text);
        CustomListeners.test.log(Status.PASS,"Verify add user text "+text);
    }
}

