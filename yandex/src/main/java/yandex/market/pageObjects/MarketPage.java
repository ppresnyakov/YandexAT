package yandex.market.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import yandex.market.steps.Hooks;

public class MarketPage extends Page{
    private WebDriver driver;

    public MarketPage() {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnCatalog(String catalogName) {
        getCatalog(catalogName).click();
    }

    private WebElement getCatalog(String name) {
        return driver.findElement(By.xpath("//span[contains(text(), '" + name + "')]"));
    }
}
