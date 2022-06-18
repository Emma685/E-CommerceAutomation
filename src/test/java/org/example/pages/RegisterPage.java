package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    public WebElement gender(String str)
    {
        WebElement gen = null;
        if (str.contains("Male"))
        {
            gen = Hooks.driver.findElement(By.id("gender-male"));
        }
        else if (str.contains("Female"))
        {
            gen = Hooks.driver.findElement(By.id("gender-female"));
        }

        return gen;
    }


    public WebElement firstName()
    {
        WebElement first = Hooks.driver.findElement(By.name("FirstName"));
        return first;
    }


    public WebElement lastName()
    {
        WebElement last = Hooks.driver.findElement(By.name("LastName"));
        return last;
    }


    // returns a Static List
    public WebElement bdDay()
    {
        WebElement day = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        return day;
    }


    // returns a Static List
    public WebElement bdMonth()
    {
        WebElement month = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        return month;
    }


    // returns a Static List
    public WebElement bdYear()
    {
        WebElement year = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        return year;
    }


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


    public WebElement confirmPassword()
    {
        WebElement confirm = Hooks.driver.findElement(By.name("ConfirmPassword"));
        return confirm;
    }


    public WebElement registerBtn()
    {
        WebElement regBtn = Hooks.driver.findElement(By.id("register-button"));
        return regBtn;
    }


    public WebElement regMsg()
    {
        WebElement msg = Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]"));
        return msg;
    }






}
