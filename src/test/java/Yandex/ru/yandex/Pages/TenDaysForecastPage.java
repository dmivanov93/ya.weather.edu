package Yandex.ru.yandex.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Yandex.ru.yandex.Util.CommonMethods.*;

import java.util.List;

public class TenDaysForecastPage {

    WebDriver driver;
    private String locatorKey = "forecast-details__day-info";
    private By headerBannerLabel = By.partialLinkText("Прогноз на 10 дней");

    public TenDaysForecastPage(WebDriver driver) {
        this.driver = driver;
        System.out.println("Инициализирован инстанс страницы " + this.getClass().getSimpleName());
    }

    private List<WebElement> daysInfoFinder() {
        List<WebElement> list = driver.findElements(By.xpath("//dd[@class='" + locatorKey + "']"));
        System.out.println("Обнаружено элементов, удовлетворяющих локатору: " + list.size());
        return list;
    }

    public void pageCheckContent() {
        contentCheck(daysInfoFinder());
    }

    public void headerBannerLabelCheck() {
        try {
            String actualLabelText = driver.findElement(headerBannerLabel).getText();
            Assert.assertEquals("Прогноз на 10 дней", actualLabelText);
            System.out.println("Заголовок страницы: " + actualLabelText);
        } catch (NullPointerException e) {
            System.out.println("Не удалось найти заголовок на странице, либо он не соответствует условию.");
            throw new NullPointerException(e.getMessage());
        }
    }
}
