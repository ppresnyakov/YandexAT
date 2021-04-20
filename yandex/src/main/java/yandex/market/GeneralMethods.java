package yandex.market;


import cucumber.api.DataTable;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class GeneralMethods {

    public static void fillField(WebElement locator, String value){
        locator.clear();
        locator.click();
        locator.sendKeys(value);
    }

    public static void moveToElementAndClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click(element);
        action.perform();
    }

    public static  void moveToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action
                .moveToElement(element)
                .build()
                .perform();
    }

    public static void switchDriverToNextTab(WebDriver driver) {
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window((String) tabs.get(1));
    }

    public static boolean checkTitle(WebDriver driver, String title) {
        return driver.getTitle().equals(title);
    }

    @Attachment
    public static byte[] getScreenshot(WebDriver driver){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources","screen.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static Map<String, String> getMapFromTable(DataTable table) {
        return table.asMap(String.class, String.class);
    }
}
