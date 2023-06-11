package org.javaciraptors;

import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void loginTest() {

        WebElement login = getDriver().findElement(By.xpath("//a[normalize-space()='Log in']"));
        login.click();

        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Email']")));

        WebElement inputEmail = getDriver().findElement(By.xpath("//label[@for='Email']"));

        Assert.assertEquals(inputEmail.getText(), "Email:");
    }

}
