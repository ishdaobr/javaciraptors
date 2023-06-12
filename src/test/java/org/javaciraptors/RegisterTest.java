package org.javaciraptors;

import org.javaciraptors.model.MainPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void clickRegister() {

        MainPage mainPage = new MainPage(getDriver())
                .clickRegister();

//        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Register']")));

        WebElement textRegister =  getDriver().findElement(By.xpath("//h1[normalize-space()='Register']"));

        Assert.assertEquals(textRegister.getText(),"Register");
    }
}
