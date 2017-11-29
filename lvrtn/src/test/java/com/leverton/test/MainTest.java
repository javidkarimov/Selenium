package com.leverton.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.leverton.pom_pages.*;
import org.junit.Assert;

/**
 *
 * @author I'm JavKa
 * I Believe I can fly
 */
public class MainTest {
    
   static WebDriver driver; //property to store the driver instance
   static StringBuffer verificationErrors = new StringBuffer();
   Helpers helper = new Helpers(driver);
   
    
    @Before
    public void setUp() {
         System.setProperty("webdriver.chrome.driver", Util.CHROME_PATH); // <<-- Please write correct path | Its my own
        driver = new ChromeDriver();
        driver.get(Util.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
    }

    @Test
    public void testLogIn(){
        System.out.println("TC1: Checking Login");
        LoginPOM login = new LoginPOM(driver);
//        login.login("test", "Test"); You can call like that
        helper.waitForElementClickable(login.name, 20);
        login.clearUserName();
        login.setUserName("test");
        login.clearPassword();
        login.setPassword("test");
        login.clickSubmit();
        //I can use in here try catch block. But best experience is Junit catches errors itself.
        String actual_error = login.actualerror.getText();
        Assert.assertEquals(Util.EXPECT_ERROR, actual_error); //checking with given error
    }
    
    @Test
    public void checkingLanguage() throws InterruptedException{
        System.out.println("TC2: Starting Test Language Selector");
        LanguagePOM language = new LanguagePOM(driver);
        language.setDeutsch();
        String set_deutsch = language.text.getText();
        Assert.assertEquals(Util.SET_DEUTSCH, set_deutsch);
        System.out.println("Set Deutsch Successfull");
        Thread.sleep(1000);
        language.setEnglish();
        String set_english = language.text.getText();
        Assert.assertEquals(Util.SET_ENGLISH, set_english);
        System.out.println("Set English Successfull");
        Thread.sleep(1000);
        language.setEspanol();
        String set_espanol = language.text.getText();
        Assert.assertEquals(Util.SET_ESPANOL, set_espanol);
        System.out.println("Set Espanol Successfull");
    }
    
    
    
}
