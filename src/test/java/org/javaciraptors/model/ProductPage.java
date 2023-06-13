package org.javaciraptors.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return Double.parseDouble(getDriver().findElement(By.xpath("//span[@itemprop='ratingValue']")).getText().trim());
    }

    public Integer getReviewsCount() {
        return Integer.parseInt(getDriver().findElement(By.xpath("//span[@itemprop='reviewCount']")).getText().trim());
    }

    public String getStockStatus() {
        return getDriver().findElement(By.xpath("//div[@class='stock']/span[@class='value']")).getText().trim();
    }
}
