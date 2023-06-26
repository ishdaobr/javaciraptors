package org.javaciraptors.model.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage<Generic extends BaseHeaderComponent> extends BaseModel {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic getHeader();

}
