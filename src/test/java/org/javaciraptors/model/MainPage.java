package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickRegister() {
        getDriver().findElement(By.xpath("//a[normalize-space()='Register']")).click();
        return this;
    }
}