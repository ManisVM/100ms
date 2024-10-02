package org.demo.PageObjects;

import java.util.Random;

import org.demo.BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class StartPage extends Base {


    @FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
    WebElement NotARobotCheck;

    @FindBy(xpath="//button[contains(text(), 'Login with')]")
    WebElement LoginWithEmailBtn;

    @FindBy(name="email")
    WebElement EmailIdBox;

    @FindBy(name="password")
    WebElement PasswordBox;

    @FindBy(xpath="//button[text()='Log In']")
    WebElement LoginBtn;

    public StartPage(WebDriver driver){
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);  
    }

    
    public PreviewPage goToStartPage() throws InterruptedException{
        driver.get("https://dashboard.100ms.live/dashboard");
        LoginWithEmailBtn.click();
        EmailIdBox.sendKeys("addidmanis8988@gmail.com");
        Thread.sleep((new Random().nextInt(3)+2)*1000);
        PasswordBox.sendKeys("Manis@221020");
        Thread.sleep((new Random().nextInt(3)+2)*1000);
        // WebElement captchaIframe = driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]"));
        // driver.switchTo().frame(captchaIframe);
        // Thread.sleep((new Random().nextInt(3)+2)*1000);
        // NotARobotCheck.click();
        // driver.switchTo().defaultContent();
        // Thread.sleep((new Random().nextInt(3)+2)*1000);
        //MANUALLY DO THE CAPTCHA SINCE IT CANNOT BE AUTOMATABLE 
        Thread.sleep(10000);
        LoginBtn.click();
        Thread.sleep((new Random().nextInt(3)+2)*1000);
        return new PreviewPage(driver);



    }
    
    
}
