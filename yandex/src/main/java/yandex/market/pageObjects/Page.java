package yandex.market.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public boolean checkTitle(WebDriver driver, String title) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs(title));
        return true;
    }
}
