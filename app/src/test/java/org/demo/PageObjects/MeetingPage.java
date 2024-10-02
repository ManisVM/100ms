package org.demo.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MeetingPage {

    //div/p
    @FindBy(xpath = "//div/p")
    List<WebElement> MeetingWindowText;

    public MeetingPage(WebDriver driver){
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(factory, this);
    }

    public void VerifyTheMeetingPage(){
        String actual="";
        for (WebElement ele : MeetingWindowText) {
             actual= ele.getText();
            // System.out.println(actual+"--------------");
            
            
        }
        System.out.println(actual+"--------------");
        if(actual.equals("Sit back and relax till others join")){
            System.out.println("-----Test Case passed----");
        }else{

        System.out.println("-----Test Case Failed----");
    }
}
}

