package org.javaciraptors.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'page-title']//a")
    private WebElement productLink;

    @FindBy(id = "AddProductReview_Title")
    private WebElement reviewTitleField;

    @FindBy(id = "AddProductReview_ReviewText")
    private WebElement reviewTextField;

    @FindBy(id = "addproductrating_1")
    private WebElement radioButton1;

    @FindBy(id = "addproductrating_2")
    private WebElement radioButton2;

    @FindBy(id = "addproductrating_3")
    private WebElement radioButton3;

    @FindBy(id = "addproductrating_4")
    private WebElement radioButton4;

    @FindBy(id = "addproductrating_5")
    private WebElement radioButton5;

    @FindBy(xpath = "//form[@action = '/productreviews/2']/div/input")
    private WebElement submitReviewButton;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]")
    private WebElement lastAddedProductReview;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//div[@class = 'review-title']")
    private WebElement reviewTitle;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//div[@class = 'review-text']")
    private WebElement reviewText;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//div[@class = 'review-info']/span[@class = 'user']")
    private WebElement reviewUserName;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//div[@class = 'review-info']/span[@class = 'date']")
    private WebElement reviewDate;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//span[contains(text(), 'Yes')]")
    private WebElement yesReviewButton;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//span[contains(text(), 'No')]")
    private WebElement noReviewButton;

    @FindBy(xpath = "//div[@class = 'product-review-item'][last()]//div[@class = 'rating']/div")
    private WebElement starRating;

    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    public ProductReviewPage clickProductLink() {
        productLink.click();

        return this;
    }

    public ProductReviewPage enterReviewTitle(String title) {
        reviewTitleField.click();
        reviewTitleField.sendKeys(title);

        return this;
    }

    public ProductReviewPage enterReviewText(String text) {
        reviewTextField.sendKeys(text);

        return this;
    }

    public ProductReviewPage clickRadioButton1() {
        radioButton1.click();

        return this;
    }

    public ProductReviewPage clickRadioButton2() {
        radioButton2.click();

        return this;
    }

    public ProductReviewPage clickRadioButton3() {
        radioButton3.click();

        return this;
    }

    public ProductReviewPage clickRadioButton4() {
        radioButton4.click();

        return this;
    }

    public ProductReviewPage clickRadioButton5() {
        radioButton5.click();

        return this;
    }

    public ProductReviewPage clickSubmitReview() {
        submitReviewButton.click();

        return this;
    }

    public String getReviewTitle() {

        return reviewTitle.getText();
    }

    public String getReviewText() {

        return reviewText.getText();
    }

    public String getReviewUserName() {

        return reviewUserName.getText();
    }

    public String getReviewDate() {

        return reviewDate.getText();
    }

    public String getReviewRating() {

        return starRating.getAttribute("style").toString();
    }

    public ProductReviewPage clickYesButton() {
        yesReviewButton.click();

        return this;
    }

    public ProductReviewPage clickNoButton() {
        noReviewButton.click();

        return this;
    }
}

