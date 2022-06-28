package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        driver.get("https://staging.admiralcasino.co.uk");

        WebElement userField = driver.findElement(By.id("user"));
        WebElement passwordField = driver.findElement(By.id("password"));

        Assert.assertTrue(userField.isDisplayed());
        System.out.println("user field is displayed - Assert passed");

        Assert.assertTrue(userField.isDisplayed());
        System.out.println("password field is displayed - Assert passed");
    }
}
