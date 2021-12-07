package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.By;

public class AdminPage extends Utility {


    public void adminMenuTabs(By tabName) {
        clickOnElement(tabName);
    }


}
