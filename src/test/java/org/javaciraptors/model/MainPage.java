package org.javaciraptors.model;

import org.javaciraptors.model.base.BaseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseModel {

    @FindBy(linkText = "Register")
    private WebElement registerButton;

    @FindBy(xpath = "//h2[@class = 'topic-html-content-header']")
    private WebElement contentHeader;

    @FindBy(linkText = "$25 Virtual Gift Card")
    private WebElement productItem;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickRegister() {
        registerButton.click();

        return this;
    }

    public String getContentHeader() {
        return contentHeader.getText();
    }

    public MainPage clickProduct() {
        productItem.click();
        return this;
    }
}
