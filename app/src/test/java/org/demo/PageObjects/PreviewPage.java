package org.demo.PageObjects;

import java.time.Duration;
import java.util.Set;

import org.demo.BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreviewPage extends Base {

    @FindBy(xpath = "//div[text()='Create Room']")
    WebElement CreateRoomBtn;

    @FindBy(xpath = "//div[text()='Continue']")
    WebElement ContinueBtn;

    @FindBy(xpath = "//div//child::p[text()='Join as ']")
    WebElement JoinAsHost;

    // button/div[text()='Join Now']
    @FindBy(xpath = "//button/div[text()='Join Now']")
    WebElement JoinNow;

   
    @FindBy(xpath = "//input[@placeholder='Enter name']")
    WebElement EnterName;

    public PreviewPage(WebDriver driver) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    // Method to set up the room by clicking the appropriate buttons
    public void SetupRoom() throws InterruptedException {
        // Wait for CreateRoomBtn to be clickable and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for the "Create Room" button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(CreateRoomBtn));
        CreateRoomBtn.click();

        // Wait for the "Continue" button to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn));
        ContinueBtn.click();

        // Wait for the "Join as Host" element to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(JoinAsHost));
        JoinAsHost.click();

        // Get the current window handle
        String ParentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!window.equals(ParentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter name']")));
        Actions act= new Actions(driver);
        act.moveToElement(EnterName);
        EnterName.sendKeys("Manis");
        wait.until(ExpectedConditions.elementToBeClickable(JoinNow));
        JoinNow.click();


    }



}
