package yandex.market.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import yandex.market.steps.Hooks;


public class MainPage extends Page{
    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='services-new__list']")
    WebElement services;

    public MainPage() {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);

    }

    public void clickOnService(String service) {
        getService(service).click();
    }

    private WebElement getService(String service) {
        return services.findElement(By.xpath(".//div[contains(text(), '" + service + "')]"));
    }
}
