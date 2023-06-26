package org.javaciraptors.model;

import org.javaciraptors.model.base.BaseMainHeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BaseMainHeaderPage {

    @FindBy(xpath = "//div[@class='product-price']")
    private WebElement price;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement name;

    @FindBy(xpath = "//div[@class='short-description']")
    private WebElement shortDescription;

    @FindBy(xpath = "//div[@class='full-description']")
    private WebElement fullDescription;

    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    private WebElement addToCardButton;

    @FindBy(xpath = "//span[@itemprop='ratingValue']")
    private WebElement rating;

    @FindBy(xpath = "//div[@class='old-product-price']/span")
    private WebElement oldPrice;

    @FindBy(xpath = "//span[@itemprop='reviewCount']")
    private WebElement reviewsCount;

    @FindBy(xpath = "//div[@class='stock']/span[@class='value']")
    private WebElement stockStatus;

    @FindBy(xpath = "//div[@class='overview']")
    private WebElement freeShipping;

    @FindBy(xpath = "//div[@class='product-review-links']/a[2]")
    private WebElement addAndReadReview;

    @FindBy(xpath = "//input[@class='qty-input valid']")
    private WebElement setCountButton;

    @FindBy(xpath = "//li[@class='tag']/a")
    private List<WebElement> tagList;

    @FindBy(xpath = "//input[@class='recipient-name']")
    private WebElement setRecipientNameField;

    @FindBy(xpath = "//input[@class='recipient-email']")
    private WebElement setRecipientEmailField;

    @FindBy(xpath = "//input[@class='sender-name']")
    private WebElement senderNameField;

    @FindBy(xpath = "//input[@class='sender-email']")
    private WebElement senderEmailField;

    @FindBy(xpath = "//textarea[@class='message']")
    private WebElement setMessageField;

    @FindBy(xpath = "//select[@id='product_attribute_28_7_10']")
    private WebElement shoeSize;

    @FindBy(xpath = "//input[@value='Email a friend']")
    private WebElement emailFriendsButton;

    @FindBy(xpath = "//input[@value='Add to wishlist']")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//input[@value='Add to compare list']")
    private WebElement addToCompareList;

    @FindBy(xpath = "//select[@id='product_attribute_5_7_1']")
    private WebElement shirtSize;

    @FindBy(xpath = "//select[@id='product_attribute_71_9_15']")
    private WebElement setJewelryMaterialButton;

    @FindBy(xpath = "//input[@id='product_attribute_71_10_16']")
    private WebElement setJewelryMaterialLength;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return price.getText().trim();
    }

    public String getName() {
        return name.getText().trim();
    }

    public String getShortDescription() {
        return shortDescription.getText().trim();
    }

    public String getFullDescription() {
        return fullDescription.getText().trim();
    }

    public ProductPage addToCart() {
        addToCardButton.click();
        return this;
    }

    public Double getRating() {
        return Double.parseDouble(rating.getText().trim());
    }

    public Double getOldPrice() {
        return Double.parseDouble(oldPrice.getText().trim());
    }

    public Integer getReviewsCount() {
        return Integer.parseInt(reviewsCount.getText().trim());
    }

    public String getStockStatus() {
        return stockStatus.getText().trim();
    }

    public boolean getFreeShipping() {
        return freeShipping.getText().contains("Free shipping");
    }

    public ProductReviewPage addAndReadReview() {
        addAndReadReview.click();
        return new ProductReviewPage(getDriver());
    }

    public ProductPage setCount(int number) {
        setCountButton.sendKeys(String.valueOf(number));
        return this;
    }

    public boolean checkTag(String tagName) {
        for (WebElement tag : tagList) {
            if (tag.getText().trim().equals(tagName)) {
                return true;
            }
        }
        return false;
    }

    public ProductPage setRecipientName(String name) {
        setRecipientNameField.sendKeys(name);
        return this;
    }

    public ProductPage setRecipientEmail(String email) {
        setRecipientEmailField.sendKeys(email);
        return this;
    }

    public ProductPage setSenderName(String name) {
        senderNameField.sendKeys(name);
        return this;
    }

    public ProductPage setSenderEmail(String email) {
        senderEmailField.sendKeys(email);
        return this;
    }

    public ProductPage setMessage(String message) {
        setMessageField.sendKeys(message);
        return this;
    }

    public ProductPage setShoeSize(String size) {
        Select sizeSelect = new Select(shoeSize);
        sizeSelect.selectByVisibleText(size);
        return this;
    }

    public ProductPage setShoeColor(String color) {
        getDriver().findElement(By.xpath("//span[@title='" + color + "']")).click();
        return this;
    }

    public EmailFriendsPage clickEmailFriends() {
        emailFriendsButton.click();
        return new EmailFriendsPage(getDriver());
    }

    public ProductPage addToWishList() {
        addToWishListButton.click();
        return this;
    }

    public CompareProductsPage addToCompareList() {
        addToCompareList.click();
        return new CompareProductsPage(getDriver());
    }

    public ProductPage setShirtSize(String size) {
        Select sizeSelect = new Select(shirtSize);
        sizeSelect.selectByVisibleText(size);
        return this;
    }

    public ProductPage setJewelryMaterial(String material) {
        Select sizeSelect = new Select(setJewelryMaterialButton);
        sizeSelect.selectByVisibleText(material);
        return this;
    }

    public ProductPage setJewelryLength(String length) {
        setJewelryMaterialLength.sendKeys(length);
        return this;
    }

    public ProductPage setJewelryPendant(String pendant) {
        getDriver().findElement(By.xpath("//ul[@class='option-list']//*[contains(text(), '" + pendant + " ')]")).click();
        return this;
    }
}
