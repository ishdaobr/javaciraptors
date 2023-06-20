package org.javaciraptors;

import org.javaciraptors.model.ProductPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CompareProductsTest extends BaseTest {

    @Test
    public void testClearCompareList() {
        final String emptyListText = "You have no items to compare.";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        String pageText = new ProductPage(getDriver())
                .addToCompareList()
                .clearCompareList()
                .emptyCompareListText();

        Assert.assertEquals(pageText, emptyListText);
    }

    @Ignore
    @Test
    public void testRemoveProduct() {
        final int productNumber = 3;
        final String productName = "$25 Virtual Gift Card";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        new ProductPage(getDriver())
                .addToCompareList()
                .clickLogo();

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for $25 Virtual Gift Card']")).click();

        String prodName = new ProductPage(getDriver())
                .addToCompareList()
                .removeProduct(productNumber)
                .productName(productName);

        Assert.assertEquals(prodName, productName);
    }

    @Test
    public void testOpenProductPage() {
        final String productName = "$25 Virtual Gift Card";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        new ProductPage(getDriver())
                .addToCompareList()
                .clickLogo();

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for $25 Virtual Gift Card']")).click();

        String prodName = new ProductPage(getDriver())
                .addToCompareList()
                .goToProductPage(productName)
                .getName();

        Assert.assertEquals(prodName, productName);
    }
}
