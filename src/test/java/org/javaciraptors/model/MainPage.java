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

    public String getContentHeader() {

        return getDriver().findElement(By.xpath("//h2[@class = 'topic-html-content-header']")).getText();
    }

    public MainPage clickProduct() {
        getDriver().findElement(By.linkText("$25 Virtual Gift Card")).click();
        return this;
    }
}
