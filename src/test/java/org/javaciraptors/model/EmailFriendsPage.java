package org.javaciraptors.model;

import org.javaciraptors.model.base.BaseModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendsPage extends BaseModel {

    @FindBy(xpath = "//a[@class='product']")
    private WebElement productName;

    @FindBy(xpath = "//input[@class='friend-email']")
    private WebElement emailFriend;

    @FindBy(xpath = "//input[@class='your-email']")
    private WebElement myEmail;

    @FindBy(xpath = "//textarea[@class='personal-message']")
    private WebElement addMessage;

    @FindBy(xpath = "//input[@name='send-email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    private WebElement errors;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement result;

    public EmailFriendsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return productName.getText().trim();
    }

    public ProductPage goProductPage() {
        productName.click();
        return new ProductPage(getDriver());
    }

    public EmailFriendsPage addFriendEmail(String email) {
        emailFriend.sendKeys(email);
        return this;
    }

    public EmailFriendsPage addMyEmail(String email) {
        myEmail.sendKeys(email);
        return this;
    }

    public EmailFriendsPage addMessage(String message) {
        addMessage.sendKeys(message);
        return this;
    }

    public EmailFriendsPage clickSendEmail() {
        sendEmailButton.click();
        return this;
    }

    public String getError() {
        return errors.getText().trim();
    }

    public String getResult() {
        return result.getText().trim();
    }
}
