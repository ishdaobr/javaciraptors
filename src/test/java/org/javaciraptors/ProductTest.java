package org.javaciraptors;

import org.javaciraptors.model.ProductPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test
    public void testCheckLaptopPriceTest() {
        final String price = "1590.00";

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']"))).click();
        String productPrice = new ProductPage(getDriver()).getPrice();

        Assert.assertEquals(productPrice, price);
    }

    @Test
    public void testCheckProductName() {
        final String name = "14.1-inch Laptop";

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']"))).click();

        String productName = new ProductPage(getDriver()).getName();

        Assert.assertEquals(productName, name);
    }

    @Test
    public void testCheckBackToMainPage() {
        final String welcomeText = "Welcome to our store";

        getWait2().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']"))).click();

        new ProductPage(getDriver()).clickLogo();
        String text = getDriver().findElement(By.xpath("//h2[@class='topic-html-content-header']")).getText().trim();

        Assert.assertEquals(text, welcomeText);
    }
}
