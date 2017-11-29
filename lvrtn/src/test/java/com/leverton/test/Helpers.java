package com.leverton.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author JavKa
 */
public class Helpers {

    WebDriver driver; //property to store the driver instance

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            //element is present and clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Error e) {
            return false;
        }
    }


}
