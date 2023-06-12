package org.javaciraptors.runner;

import org.javaciraptors.model.MainPage;
import org.javaciraptors.runner.order.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerClick() {

        MainPage mainPage = new MainPage(getDriver())
                .clickRegister();

        Assert.assertEquals(getDriver().findElement(By.xpath("//a[normalize-space()='Register']")).getText(), "Register");
    }
}
