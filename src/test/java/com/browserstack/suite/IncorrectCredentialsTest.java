package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class IncorrectCredentialsTest extends BrowserStackTestNGTest {

    @Test
    public void loginErrorMessage() throws Exception {
        String url = "https://staging.admiralcasino.co.uk";
        WebElement loginLnk = driver.findElement(By.xpath("//a[@class='link link-main-header']"));
        WebElement userName = driver.findElement(By.id("nickname"));
        WebElement password =  driver.findElement(By.id("password"));
        WebElement loginButton =  driver.findElement(By.xpath("//*[@id=\"dialog\"]/div/div[2]/div/app-login/form/div/button"));

        driver.get(url);
        basicAuthentication();
        acceptCookies();
        loginLnk.click();
        userName.sendKeys("fakeuser2000");
        password.sendKeys("fakepassword2000");
        loginButton.click();

        Thread.sleep(5000);

        String expectedErrorMessage = "Incorrect nickname/password combination.";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"dialog\"]/div/div[2]/div/app-login/form/app-alert/div/ul/li"))
                .getText();
        if (expectedErrorMessage.equalsIgnoreCase(actualErrorMessage)) {
            System.out.println("Error message is correct");
        } else {
            System.out.println("Error message is incorrect");
        }
    }

    public void basicAuthentication(){
        driver.findElement(By.id("user"))
                .sendKeys("admin");
        driver.findElement(By.id("password"))
                .sendKeys("matrix4215");
        driver.findElement(By.xpath("/html/body/form/input[4]"))
                .click();
    }
    public void acceptCookies(){
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']"))
                .click();
    }
}
