package org.javaciraptors;

import org.javaciraptors.model.ProductPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test
    public void testCheckLaptopPriceTest() {
        final String price = "1590.00";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        String productPrice = new ProductPage(getDriver()).getPrice();

        Assert.assertEquals(productPrice, price);
    }

    @Test
    public void testCheckProductName() {
        final String name = "14.1-inch Laptop";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        String productName = new ProductPage(getDriver()).getName();

        Assert.assertEquals(productName, name);
    }

    @Test
    public void testCheckBackToMainPage() {
        final String welcomeText = "Welcome to our store";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        new ProductPage(getDriver()).clickLogo();
        String text = getDriver().findElement(By.xpath("//h2[@class='topic-html-content-header']"))
                .getText().trim();

        Assert.assertEquals(text, welcomeText);
    }

    @Test
    public void testFreeShipping() {
        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for Build your own cheap computer']"))
                .click();

        Assert.assertTrue(new ProductPage(getDriver()).getFreeShipping());
    }

    @Test
    public void testCheckTag() {
        final String tag = "computer";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for Build your own cheap computer']"))
                .click();

        Assert.assertTrue(new ProductPage(getDriver()).checkTag(tag));
    }

    @Test
    public void testOrderGiftCard() {
        final String recipientName = "Maxim";
        final String recipientEmail = "2222@ddd.rr";
        final String senderName = "Artem";
        final String senderEmail = "dddd@djjj.ccc";
        final String message = "Best wishes";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for $25 Virtual Gift Card']"))
                .click();

        new ProductPage(getDriver())
                .setRecipientName(recipientName)
                .setRecipientEmail(recipientEmail)
                .setSenderName(senderName)
                .setSenderEmail(senderEmail)
                .setMessage(message)
                .addToCart();

        getDriver().findElement(By.xpath("//li[@id='topcartlink']")).click();

        Assert.assertEquals(getDriver().findElement(
                By.xpath("//a[@class='product-name']")).getText().trim(), "$25 Virtual Gift Card");
    }
}
