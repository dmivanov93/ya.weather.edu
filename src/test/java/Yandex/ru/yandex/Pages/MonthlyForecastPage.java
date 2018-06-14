package Yandex.ru.yandex.Pages;

import org.junit.Assert;
import org.openqa.selenium.*;

import static Yandex.ru.yandex.Util.CommonMethods.*;

import java.util.List;

public class MonthlyForecastPage {

    WebDriver driver;
    private By topBannerLabel = By.xpath("//h1");
    private By longTempGraph = By.xpath("//div[@class='graph-longterm__graph']");
    private By climateGraph = By.xpath("//div[@class='graph-climate__graph']");
    private By conditionGraph = By.xpath("//div[@class='graph-condition__graph']");
    private By precipitationsGraph = By.xpath("//div[@class='graph-precipitations__graph']");

    List<By> locators;

    public MonthlyForecastPage(WebDriver driver) {
        this.driver = driver;
        System.out.println("Инициализирован инстанс страницы " + this.getClass().getSimpleName());
    }

    public void checkIfPageOpen(String cityName) {
        Assert.assertEquals(driver.findElement(topBannerLabel).getText(), "Прогноз погоды в " + cityName + " на месяц");
    }

    public void pageContentCheck() {
        //демонстрация работы с массивами и циклами
        locators.add(longTempGraph);
        locators.add(climateGraph);
        locators.add(conditionGraph);
        locators.add(precipitationsGraph);
        contentCheck(locators, driver);
    }
}
