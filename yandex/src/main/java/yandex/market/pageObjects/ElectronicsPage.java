package yandex.market.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import yandex.market.steps.Hooks;

public class ElectronicsPage extends Page{
    private WebDriver driver;

    public ElectronicsPage() {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickOnCatalogItem(String catalogName) {
        getCatalogItem(catalogName).click();
    }

    private WebElement getCatalogItem(String name) {
        return driver.findElement(By.xpath("//a[text() = '" + name + "']"));
    }
}
