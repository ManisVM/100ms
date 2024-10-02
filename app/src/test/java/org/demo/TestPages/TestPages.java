package org.demo.TestPages;

import org.demo.BaseClass.Base;
import org.demo.PageObjects.MeetingPage;
import org.demo.PageObjects.PreviewPage;
import org.demo.PageObjects.StartPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPages extends Base{

  private StartPage startpage;
  private PreviewPage previewpage;
  private MeetingPage meetingpage;

    @BeforeMethod
    public void setup() {
		launchBrowser();
	}

    @AfterMethod
    public void teardown() {
		closeBrowser();
	}

  @Test
  public void TestStart() throws InterruptedException{
    startpage = new StartPage(driver);
    meetingpage= new MeetingPage(driver);
    startpage.goToStartPage()
    .SetupRoom();
    meetingpage.VerifyTheMeetingPage();


    // previewpage = new PreviewPage();
    // startpage.goToStartPage();
    // previewpage.SetupRoom();

  }


    
}
