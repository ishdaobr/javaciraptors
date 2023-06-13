package org.javaciraptors;

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
        String laptopPrice = getWait2().until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='product-price']"))).getText().trim();

        Assert.assertEquals(laptopPrice, price);
    }
}
