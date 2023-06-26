package org.javaciraptors.model.component;

import org.javaciraptors.model.MainPage;
import org.javaciraptors.model.base.BaseHeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainHeaderComponent extends BaseHeaderComponent {

    public MainHeaderComponent(WebDriver driver) {
        super(driver);
    }

    public MainPage clickLogo() {
        getDriver().findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']")).click();
        return new MainPage(getDriver());
    }
}
