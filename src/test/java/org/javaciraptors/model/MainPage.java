package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickRegister() {
        getDriver().findElement(By.xpath("//a[text()='Register']")).click();
        return this;
    }

    public MainPage clickLogin() {
        getDriver().findElement(By.xpath("//a[text()='Log in']")).click();
        return this;
    }
}
