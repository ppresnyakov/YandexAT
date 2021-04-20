package yandex.market.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

public class CucumberSteps {

    MainPageSteps mainPageSteps;
    MarketPageSteps marketPageSteps;
    ElectronicsPageSteps electronicsPageSteps;
    ProductPageSteps productPageSteps;


    @Когда("перешел на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        Hooks.getDriver().get(url);
        mainPageSteps = new MainPageSteps(Hooks.getDriver());
        marketPageSteps = new MarketPageSteps(Hooks.getDriver());
        electronicsPageSteps = new ElectronicsPageSteps(Hooks.getDriver());
        productPageSteps = new ProductPageSteps(Hooks.getDriver());
    }

    @Тогда("заголовок главной страницы -  '(.*)'")
    public void проверить_заголовок_главной_страницы(String navItemName) {
        mainPageSteps.checkTitle(navItemName);
    }

    @Когда("нажат сервис - '(.*)'")
    public void нажать_сервис(String service) {
        mainPageSteps.clickOnService(service);
    }

    @Тогда("заголовок страницы маркета -  '(.*)'")
    public void проверить_заголовок_маркета(String navItemName) {
        marketPageSteps.checkTitle(navItemName);
    }

    @Когда("нажат каталог - '(.*)'")
    public void нажать_каталог(String catalogName) {
        marketPageSteps.clickOnCatalog(catalogName);
    }

    @Тогда("заголовок страницы каталога электроника -  '(.*)'")
    public void проверить_заголовок_каталога_электроники(String catalogPageTitle) {
        electronicsPageSteps.checkTitle(catalogPageTitle);
    }

    @Когда("нажат элемент каталога - '(.*)'")
    public void нажать_элемент_каталога(String catalogName) {
        electronicsPageSteps.clickOnCatalogItem(catalogName);
    }

    @Тогда("заголовок страницы каталога телевизоров содержит -  '(.*)'")
    public void проверить_заголовок_каталога_телевизоров(String TVPageTitle) {
        productPageSteps.checkTitle(TVPageTitle);
    }

    @Когда("установлен ценовой диапозон -  '(.*)','(.*)'")
    public void установлен_ценовой_диапозон(String priceType, String priceValue) {
        productPageSteps.setPriceTo(priceType, priceValue);
    }

    @И("выбран производитель '(.*)'")
    public void выбрать_производителя(String name) {
        productPageSteps.selectManufacturer(name);
    }

    @Тогда("товаров >= '(.*)'")
    public void товаров_больше_чем(int threshold) throws InterruptedException {
        productPageSteps.checkItemsQuantity(threshold);
    }

    @Когда("выполнен поиск товара под номером '(.*)'")
    public void поиск_товара_под_номером(int number) {
        productPageSteps.searchByItemNumber(number);
    }

    @Тогда("название товара в списке под номером '(.*)' не изменился")
    public void товар_в_списке_под_номером(int number) throws InterruptedException {
        productPageSteps.checkItemTitle(number);
    }
}
