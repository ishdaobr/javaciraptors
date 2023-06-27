package org.javaciraptors;

import org.javaciraptors.model.RegistrationPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegTest extends BaseTest {

    @Test
    public void clickRegister() {

       new RegistrationPage(getDriver())
                .getHeader()
                .clickRegister();

        WebElement textRegister =  getDriver().findElement(By.xpath("//h1[normalize-space()='Register']"));

        Assert.assertEquals(textRegister.getText(),"Register");

    }
}
