package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebElement email()
    {
        WebElement email = Hooks.driver.findElement(By.id("Email"));
        return email;
    }


    public WebElement password()
    {
        WebElement pass = Hooks.driver.findElement(By.name("Password"));
        return pass;
    }


    public WebElement loginBtn()
    {
        WebElement logBtn = Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
        return logBtn;
    }

    public WebElement loginFailMsg()
    {
        WebElement msg = Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
        return msg;
    }

}
