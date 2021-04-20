package yandex.market.steps;


import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import yandex.market.GeneralMethods;
import yandex.market.pageObjects.MarketPage;

import static org.junit.Assert.assertTrue;

public class MarketPageSteps {
    WebDriver driver;
    private MarketPage marketPage;

    public MarketPageSteps(WebDriver driver) {
        this.driver = driver;
        this.marketPage = new MarketPage();
    }

    @Step("Заголовок  открывшейся страницы = '{title}'")
    public void checkTitle(String title) {
        GeneralMethods.switchDriverToNextTab(driver);
        assertTrue(
                marketPage.checkTitle(driver, title)
        );
    }

    @Step("Нажать на каталог '{catalogName}'")
    public void clickOnCatalog(String catalogName) {
        marketPage.clickOnCatalog(catalogName);
    }
}
