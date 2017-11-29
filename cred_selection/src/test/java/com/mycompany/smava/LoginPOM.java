package com.mycompany.smava;

import static org.openqa.selenium.By.name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Javid Karimov 
 */
public class LoginPOM {

    WebDriver driver;
    //Finding Elements for Login
    @FindBy(xpath = "html/body/div[4]/div[1]/div/div[2]/a[6]")
    WebElement anmelden;
    @FindBy(id = "signonForm.email")
    WebElement name;
    @FindBy(id = "signonForm.password")
    WebElement password;
    @FindBy(xpath = ".//*[@id='signonForm']/button")
    WebElement submit;
    @FindBy(xpath = ".//*[@id='layout-wrapper']/div[3]/div[1]/div/div/div[1]/div/ul/li")
    WebElement actualerror;

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

    public void clickAnmelden() {
        anmelden.click();
    }

    public void login(String strUsername, String strPassword) {
        clickAnmelden();
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
