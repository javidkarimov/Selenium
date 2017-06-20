
package test;

import java.sql.Driver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author User
 */
public class junit_les1 {
    
    private WebDriver driver;
    
  
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\INSTALL\\Selenium\\chromedriver.exe");
         driver = new ChromeDriver();
         
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void case1() {
        System.out.println("==========Case 1 =========");
        
    String BaseUrl = "http://www.mail.com/";
    driver.get(BaseUrl);
    String Taytl = driver.getTitle();
    String CurUrl = driver.getCurrentUrl();
    System.out.println(Taytl);
    System.out.println(CurUrl);
        System.out.println(driver.getTitle().length());
            if (CurUrl.equals(BaseUrl)){
                System.out.println("Site Works properly. Title is OK");
            }
            else {
                System.out.println("Title wrong");
            }
            
       
}
    @Test   
public void case2(){
     System.out.println("==========Case 2 =========");
     
}

    
}
