package com.leverton.pom_pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author JavKa
 */
public class LanguagePOM {
    
    WebDriver driver;
    //Finding Elements for Login
    @FindBy (xpath = ".//*[@id='user-info']/div/div/a[1]")
    WebElement deutsch;
    @FindBy (xpath = ".//*[@id='user-info']/div/div/a[2]")
    WebElement english;
    @FindBy (xpath = ".//*[@id='user-info']/div/div/a[3]")
    WebElement espanol;
    @FindBy (xpath = ".//*[@id='user-info']/div/a")
    public WebElement text;
    
    public void setDeutsch(){
        deutsch.click();
    }
    
    public void setEnglish() {
        english.click();
    }
    
    public void setEspanol(){
        espanol.click();
    }
    
     public LanguagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
