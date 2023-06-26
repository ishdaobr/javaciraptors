package org.javaciraptors.model.base;

import org.javaciraptors.model.component.MainHeaderComponent;
import org.openqa.selenium.WebDriver;

public abstract class BaseMainHeaderPage extends BasePage<MainHeaderComponent> {

    public BaseMainHeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainHeaderComponent getHeader() {
        return new MainHeaderComponent(getDriver());
    }
}
