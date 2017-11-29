package com.leverton.pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 *
 * @author I'm Javka
 */
public class LoginPOM {

    WebDriver driver;
    //Finding Elements for Login
    @FindBy(id = "username")
    public WebElement name;
    @FindBy(id = "password-field")
    WebElement password;
    @FindBy(xpath = ".//*[@id='loginForm']/div[4]/input")
    WebElement submit;
    @FindBy(xpath = ".//*[@id='loginForm']/div[1]/p[1]")
    public WebElement actualerror;

    public void setUserName(String strUsername) {
        name.sendKeys(strUsername);
    }

    public void clearUserName() {
        name.clear();
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clearPassword() {
        password.clear();
    }

    public void clickSubmit() {
        submit.click();
    }

    public void login(String strUsername, String strPassword) {
        clearUserName();
        setUserName(strUsername);
        clearPassword();
        setPassword(strPassword);
        clickSubmit();
    }

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
