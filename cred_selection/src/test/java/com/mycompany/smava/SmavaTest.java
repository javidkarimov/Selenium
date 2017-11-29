package com.mycompany.smava;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Javid Karimov
 */
public class SmavaTest {

    static WebDriver driver; //property to store the driver instance

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Util.CHROME_PATH); // <<-- Please write correct path | Its my own
        driver = new ChromeDriver();
        driver.get(Util.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
    }

    @Test
    public void testLoan() {
        LoanPOM loan = new LoanPOM(driver);
        //select Loan
        loan.clickLoan(); //Usually I use select for dropdown list but in your case your website structure comletely different.
        waitForElementClickable(loan.amountSelector, 10);
        loan.setLoan();

        //Select Duration
        waitForElementClickable(loan.lsDuration, 10);
        loan.clickDuration();
        waitForElementClickable(loan.durationSelector, 10);
        loan.setDuration();

        //Select Category
        waitForElementClickable(loan.lsCategory, 10);
        loan.clickCategory();
        waitForElementClickable(loan.categorySelector, 10);
        loan.setCategory();
        //Click first weiter button
        waitForElementClickable(loan.weiter, 10);
        loan.clickWeiter();

        // Complete Load Checking, Version #1
        //Its useless thing, I write this part just for fun
        //You can check out in Output. It will reflecte as "Status: complete"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ready = (String) js.executeScript("return document.readyState");
        System.out.println("Status:" + ready);

        // Complete Load Checking, Version #2
        String checkback = loan.completed.getText();
        assertTrue(checkback.contains("Zurück"));

    }

    @Test
    public void testLogin() throws Exception  {
        String[][] testData = Util.getDataFromExcel(Util.FILE_PATH, Util.SHEET_NAME_LOGIN, Util.TABLE_NAME); //getting test cases from excel, you can your own cases but at that time we have use loop
        String username = testData[0][0]; // get username
        String password = testData[0][1]; // get password
        LoginPOM login = new LoginPOM(driver);
        login.login(username, password);
        String actual_error = login.actualerror.getText();
        Assert.assertEquals(Util.EXPECT_ERROR, actual_error); //checking with given error

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //My Helper Methods 
    public boolean waitForElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            //element is present and clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Error Achtung) {
            return false;
        }

    }

}
