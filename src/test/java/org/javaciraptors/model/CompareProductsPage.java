package org.javaciraptors.model;

import org.javaciraptors.model.base.BaseMainHeaderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends BaseMainHeaderPage<CompareProductsPage> {

    @FindBy(xpath = "//a[@class='clear-list']")
    private WebElement clearListButton;

    @FindBy(xpath = "//div[@class='page-body']")
    private WebElement pageBodyText;

    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    public CompareProductsPage clearCompareList() {
        clearListButton.click();
        return this;
    }

    public CompareProductsPage removeProduct(int number) {
        getDriver().findElement(By.xpath("//tbody/tr[@class='overview']/td["+ number + "]/div[1]/p[1]/input[1]")).click();
        return this;
    }

    public String emptyCompareListText() {
        return pageBodyText.getText().trim();
    }

    public String productName(String productName) {
        return getDriver().findElement(
                By.xpath("//a[normalize-space()='" + productName + "']")).getText().trim();
    }

    public ProductPage goToProductPage(String productName) {
        getDriver().findElement(
                By.xpath("//a[normalize-space()='" + productName + "']")).click();
        return new ProductPage(getDriver());
    }
}
