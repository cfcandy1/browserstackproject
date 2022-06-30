package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("https://staging.admiralcasino.co.uk");

        WebElement userField = driver.findElement(By.id("user"));
        WebElement passwordField = driver.findElement(By.id("password"));

        if (userField.isDisplayed() && passwordField.isDisplayed()){
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"user and password fields are displayed!\"}}");

        } else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"fields are not displayed!\"}}");

        }
    }
}
