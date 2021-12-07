package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='OrangeHRM']")
    WebElement orangeHrmLogo;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminLink;

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pimLink;

    @FindBy(id = "welcome")
    WebElement welcomeText;

    @FindBy(id = "welcome")
    WebElement profileLink;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;


    public void verifyWelcomeText(String message){
        verifyThatTextIsDisplayed(welcomeText, message);
        CustomListeners.test.log(Status.PASS,"Verify Welcome Text " + message);

    }

    public void verifyOrangeHrmLogoIsVisible(){
        verifyThatElementIsDisplayed(orangeHrmLogo);
        CustomListeners.test.log(Status.PASS,"Verify Orange HRM Logo is displayed");
    }

    public void clickOnProfileLogo(){
        clickOnElement(profileLink);
        CustomListeners.test.log(Status.PASS,"Click on profileLink ");
    }

    public void clickOnLogout() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(logout);
        CustomListeners.test.log(Status.PASS,"Click on logout ");
    }

    // This method will select top menu categroy
    public void selectMenu(String menu) {
        List<WebElement> topMenuNames = driver.findElements(By.xpath("//div[@id='block_top_menu']//li"));
        for (WebElement names : topMenuNames) {
            if (names.getText().equalsIgnoreCase(menu)) {
                names.click();
                break;
            }
        }
    }
}
