package org.javaciraptors;

import org.javaciraptors.model.ProductPage;
import org.javaciraptors.runner.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
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

    @Ignore
    @Test
    public void testCheckProductName() {
        final String name = "14.1-inch Laptop";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for 14.1-inch Laptop']")).click();

        String productName = new ProductPage(getDriver()).getName();

        Assert.assertEquals(productName, name);
    }

    @Ignore
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

    @Ignore
    @Test
    public void testFreeShipping() {
        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for Build your own cheap computer']"))
                .click();

        Assert.assertTrue(new ProductPage(getDriver()).getFreeShipping());
    }

    @Ignore
    @Test
    public void testCheckTag() {
        final String tag = "computer";

        getDriver().findElement(
                By.xpath("//div[@class='picture']//img[@title='Show details for Build your own cheap computer']"))
                .click();

        Assert.assertTrue(new ProductPage(getDriver()).checkTag(tag));
    }

    @Ignore
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

    @Ignore
    @Test
    public void testSetShoeSize() {
        final String size = "10";

        getDriver().findElement(
                        By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel & Shoes']"))
                .click();
        getDriver().findElement(
                        By.xpath("//div[@class='product-item']//a[@title='Show details for Blue and green Sneaker']"))
                .click();

        new ProductPage(getDriver())
                .setShoeSize(size)
                .addToCart();

        getDriver().findElement(By.xpath("//li[@id='topcartlink']")).click();

        String desc = getDriver().findElement(By.xpath("//tr[@class='cart-item-row']//div[@class='attributes']")).getText();
        String cartSize = desc.substring(desc.indexOf(" "), desc.indexOf("C")).trim();

        Assert.assertEquals(cartSize, size);
    }

    @Ignore
    @Test
    public void testSetShoeColor() {
        final String color = "Green";

        getDriver().findElement(
                        By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel & Shoes']"))
                .click();
        getDriver().findElement(
                        By.xpath("//div[@class='product-item']//a[@title='Show details for Blue and green Sneaker']"))
                .click();

        new ProductPage(getDriver())
                .setShoeColor(color)
                .addToCart();

        getDriver().findElement(By.xpath("//li[@id='topcartlink']")).click();

        String desc = getDriver().findElement(By.xpath("//tr[@class='cart-item-row']//div[@class='attributes']")).getText();
        String cartColor = desc.substring(desc.lastIndexOf(":") + 1).trim();

        Assert.assertEquals(cartColor, color);
    }

    @Ignore
    @Test
    public void testSetShirtSize() {
        final String size = "2X";

        getDriver().findElement(
                        By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel & Shoes']"))
                .click();
        getDriver().findElement(
                        By.xpath("//div[@class='product-item'][1]//a"))
                .click();

        new ProductPage(getDriver())
                .setShirtSize(size)
                .addToCart();

        getDriver().findElement(By.xpath("//li[@id='topcartlink']")).click();

        String desc = getDriver().findElement(By.xpath("//tr[@class='cart-item-row']//div[@class='attributes']")).getText();
        String cartSize = desc.substring(desc.indexOf(" ")).trim();

        Assert.assertEquals(cartSize, size);
    }

    @Ignore
    @Test
    public void testSetJewelryOptions() {
        final String material = "Silver (1 mm)";
        final String length = "15";
        final String pendant = "Star";

        getDriver().findElement(
                        By.xpath("//li[@class='inactive']//a[normalize-space()='Jewelry']"))
                .click();
        getDriver().findElement(
                        By.xpath("//div[@class='product-item']//a[@title='Show details for Create Your Own Jewelry']"))
                .click();

        new ProductPage(getDriver())
                .setJewelryMaterial(material)
                .setJewelryLength(length)
                .setJewelryPendant(pendant)
                .addToCart();

        getDriver().findElement(By.xpath("//li[@id='topcartlink']")).click();

        String desc = getDriver().findElement(By.xpath("//tr[@class='cart-item-row']//div[@class='attributes']")).getText();
        String productMaterial = desc.substring(desc.indexOf(" "), desc.indexOf("L")).trim();
        String productLength = desc.substring(desc.indexOf("th:") + 4, desc.indexOf("P")).trim();
        String productPendant = desc.substring(desc.lastIndexOf(":") + 1).trim();

        Assert.assertEquals(productMaterial, material);
        Assert.assertEquals(productLength, length);
        Assert.assertEquals(productPendant, pendant);
    }
}
