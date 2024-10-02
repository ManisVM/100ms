package org.demo.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    public static WebDriver driver;

    // public Base(WebDriver driver){
    //     this.driver = driver;
    // }

    public void launchBrowser() {
        System.out.println("Launching Browser");

        // Set up WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions instance to configure browser preferences
        ChromeOptions options = new ChromeOptions();

        // Automatically allow microphone and camera access
        options.addArguments("--use-fake-ui-for-media-stream");

        // Use fake devices for testing (fake audio and video)
        options.addArguments("--use-fake-device-for-media-stream");

        // Set preferences to allow media stream access
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("profile.default_content_setting_values.media_stream_mic", 1);  // 1 = Allow microphone
            put("profile.default_content_setting_values.media_stream_camera", 1);  // 1 = Allow camera
        }});

        // Initialize ChromeDriver with the specified options
        driver = new ChromeDriver(options);

        // Maximize the window after initializing the driver
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        System.out.println("Closing Browser");

        if (driver != null) {
            driver.quit();
        }
    }
}
