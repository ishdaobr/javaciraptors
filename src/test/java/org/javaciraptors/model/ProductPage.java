package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return getDriver().findElement(By.xpath("//div[@class='product-price']")).getText().trim();
    }

    public String getName() {
        return getDriver().findElement(By.xpath("//h1[@itemprop='name']")).getText().trim();
    }

    public String getShortDescription() {
        return getDriver().findElement(By.xpath("//div[@class='short-description']")).getText().trim();
    }

    public String getFullDescription() {
        return getDriver().findElement(By.xpath("//div[@class='full-description']")).getText().trim();
    }

    public ProductPage addToCart() {
        getDriver().findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
        return this;
    }

    public Double getRating() {
        return Double.parseDouble(getDriver().findElement(By.xpath("//span[@itemprop='ratingValue']"))
                .getText().trim());
    }

    public Double getOldPrice() {
        return Double.parseDouble(getDriver().findElement(By.xpath("//div[@class='old-product-price']/span"))
                .getText().trim());
    }

    public Integer getReviewsCount() {
        return Integer.parseInt(getDriver().findElement(By.xpath("//span[@itemprop='reviewCount']"))
                .getText().trim());
    }

    public String getStockStatus() {
        return getDriver().findElement(By.xpath("//div[@class='stock']/span[@class='value']"))
                .getText().trim();
    }

    public boolean getFreeShipping() {
        return getDriver().findElement(By.xpath("//div[@class='overview']")).getText().contains("Free shipping");
    }

    public ProductReviewPage addAndReadReview() {
        getDriver().findElement(By.xpath("//div[@class='product-review-links']/a[2]")).click();
        return new ProductReviewPage(getDriver());
    }

    public ProductPage setCount(int number) {
        getDriver().findElement(By.xpath("//input[@class='qty-input valid']")).sendKeys(String.valueOf(number));
        return this;
    }

    public boolean checkTag(String tagName) {
        List<WebElement> tags = getDriver().findElements(By.xpath("//li[@class='tag']/a"));

        for (WebElement tag : tags) {
            if (tag.getText().trim().equals(tagName)) {
                return true;
            }
        }
        return false;
    }

    public ProductPage setRecipientName(String name) {
        getDriver().findElement(By.xpath("//input[@class='recipient-name']")).sendKeys(name);
        return this;
    }

    public ProductPage setRecipientEmail(String email) {
        getDriver().findElement(By.xpath("//input[@class='recipient-email']")).sendKeys(email);
        return this;
    }

    public ProductPage setSenderName(String name) {
        getDriver().findElement(By.xpath("//input[@class='sender-name']")).sendKeys(name);
        return this;
    }

    public ProductPage setSenderEmail(String email) {
        getDriver().findElement(By.xpath("//input[@class='sender-email']")).sendKeys(email);
        return this;
    }

    public ProductPage setMessage(String message) {
        getDriver().findElement(By.xpath("//textarea[@class='message']")).sendKeys(message);
        return this;
    }

    public ProductPage setShoeSize(String size) {
        Select sizeSelect = new Select(getDriver().findElement(
                By.xpath("//select[@id='product_attribute_28_7_10']")));
        sizeSelect.selectByVisibleText(size);
        return this;
    }

    public ProductPage setShoeColor(String color) {
        getDriver().findElement(By.xpath("//span[@title='" + color + "']")).click();
        return this;
    }

    public EmailFriendsPage clickEmailFriends() {
        getDriver().findElement(By.xpath("//input[@value='Email a friend']")).click();
        return new EmailFriendsPage(getDriver());
    }

    public ProductPage addToWishList() {
        getDriver().findElement(By.xpath("//input[@value='Add to wishlist']")).click();
        return this;
    }

    public CompareProductsPage addToCompareList() {
        getDriver().findElement(By.xpath("//input[@value='Add to wishlist']")).click();
        return new CompareProductsPage(getDriver());
    }

    public ProductPage setShirtSize(String size) {
        Select sizeSelect = new Select(getDriver().findElement(
                By.xpath("//select[@id='product_attribute_5_7_1']")));
        sizeSelect.selectByVisibleText(size);
        return this;
    }

    public ProductPage setJewelryMaterial(String material) {
        Select sizeSelect = new Select(getDriver().findElement(
                By.xpath("//select[@id='product_attribute_71_9_15']")));
        sizeSelect.selectByVisibleText(material);
        return this;
    }

    public ProductPage setJewelryLength(String length) {
        getDriver().findElement(By.xpath("//input[@id='product_attribute_71_10_16']")).sendKeys(length);
        return this;
    }

    public ProductPage setJewelryPendant(String pendant) {
        getDriver().findElement(By.xpath("//ul[@class='option-list']//*[contains(text(), '" + pendant + " ')]")).click();
        return this;
    }
}
