package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='product-price']"))).getText().trim();
    }

    public String getName() {
        return getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[@itemprop='name']"))).getText().trim();
    }

    public String getShortDescription() {
        return getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='short-description']"))).getText().trim();
    }

    public String getFullDescription() {
        return getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='full-description']"))).getText().trim();
    }

    public ProductPage addToCart() {
        getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@class='button-1 add-to-cart-button']"))).click();
        return this;
    }

    public Double getRating() {
        return Double.parseDouble(getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@itemprop='ratingValue']"))).getText().trim());
    }

    public Integer getReviewsCount() {
        return Integer.parseInt(getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[@itemprop='reviewCount']"))).getText().trim());

    }

    public String getStockStatus() {
        return getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='stock']/span[@class='value']"))).getText().trim();
    }
}
