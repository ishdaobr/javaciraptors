package org.javaciraptors;

import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationexerciseTest extends BaseTest {

    @Test
    public void firstTest() {
        getWait2();

        WebElement pageProduct = getDriver().findElement(By.xpath("//a[@href='/products']"));
        pageProduct.click();

        getWait5().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Close']")));

        WebElement buttonClose = getDriver().findElement(By.xpath("//span[text()='Close']"));
        buttonClose.click();

        //
    }

}
