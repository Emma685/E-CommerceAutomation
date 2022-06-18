package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;

    @Before
    public static void openBrowser() {
        // Link chromedriver.exe with code to be able to use it in driver object
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);

        // create driver object of type ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the WebSite URL and maximize browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");

    }


    @After
    public static void closeBrowser()
    {
        // close the all tabs in Browser and close the driver in the background
        driver.quit();
    }


}
