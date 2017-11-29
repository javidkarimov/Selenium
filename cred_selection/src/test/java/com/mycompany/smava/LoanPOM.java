package com.mycompany.smava;

import java.sql.Driver;
import static org.openqa.selenium.By.name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Javid Karimov
 */
public class LoanPOM {

    WebDriver driver;
//    Finding elements for Loan
    
    @FindBy(xpath = ".//*[@id='myselect']/div/input")
    WebElement lsAmount;
    @FindBy(xpath = ".//*[@id='myselect']/div/div[2]/div[10]")
    WebElement amountSelector;
    @FindBy(xpath = ".//*[@id='myselect2']/div/i")
    WebElement lsDuration;
    @FindBy(xpath = ".//*[@id='myselect2']/div/div[2]/div[2]")
    WebElement durationSelector;
    @FindBy(xpath = ".//*[@id='myselect3']/div/i")
    WebElement lsCategory;
    @FindBy(xpath = ".//*[@id='myselect3']/div/div[2]/div[3]")
    WebElement categorySelector;
    @FindBy(partialLinkText = "weiter")
    WebElement weiter;
    @FindBy(xpath = ".//*[@id='x-application']/div[1]/div/div[2]/div/div[1]/a")
    WebElement completed;

    public void clickLoan() {
        lsAmount.click();
    }

    public void setLoan() {
        amountSelector.click();
    }

    public void clickDuration() {
        lsDuration.click();
    }

    public void setDuration() {
        durationSelector.click();
    }

    public void clickCategory() {
        lsCategory.click();
    }

    public void setCategory() {
        categorySelector.click();
    }

    public void clickWeiter() {
        weiter.click();
    }

    public LoanPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
