package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("https://staging.admiralcasino.co.uk");

        WebElement userField = driver.findElement(By.id("user"));
        WebElement passwordField = driver.findElement(By.id("password"));

        if(userField.isDisplayed()){
            Assert.assertTrue(userField.isDisplayed());
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"user field is displayed!\"}}");

        } else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"user field is not displayed!\"}}");

        }


        Assert.assertTrue(passwordField.isDisplayed());
        System.out.println("password field is displayed - Assert passed");
    }
}
