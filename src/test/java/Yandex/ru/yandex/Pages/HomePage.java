package Yandex.ru.yandex.Pages;

import org.junit.Assert;
import org.openqa.selenium.*;

import static Yandex.ru.yandex.Util.CommonMethods.*;

public class HomePage {

    WebDriver driver;
    private String moscowHomePageAddress = "https://yandex.ru/pogoda/moscow";
    private By searchString = By.xpath("//input[@class='input__control']");
    private By loginButton = By.xpath("//button[@title='Войти']");
    private By moscowRegionLink = By.xpath("//a[@href='/pogoda/moscow']");
    private By weatherOnMapGraphicTemperatureButtonInputLocator = By.xpath("//input[@value='temperature']");
    private By temperatureMapLabel = By.partialLinkText(firstLetterToUpperCase("Карта температуры"));
    private By monthlyForecastLink = By.xpath("//a[@data-name = 'month']");
    private By tenDaysForecastLink = By.partialLinkText("Подробный прогноз на 10 дней");
    private By yandexHelpLink = By.partialLinkText("Помощь");

    public HomePage(WebDriver driver){
        this.driver = driver;
        getHomePage();
        System.out.println("Инициализирован инстанс страницы " + this.getClass().getSimpleName());
    }

    private void getHomePage() {
        try {
            driver.get(moscowHomePageAddress);
            System.out.println("Открыта страница: " + moscowHomePageAddress);
        } catch (Exception e) {
            System.out.println("Не удалось открыть страницу: " + moscowHomePageAddress);
            throw new NullPointerException(e.getMessage());
        }
    }

    private WebElement getSearch() {
        try {
            WebElement q = findOnElementByLocator(searchString, driver);
            System.out.println("Строка поиска найдена с локатором " + searchString);
            return q;
        } catch (NullPointerException e) {
            System.out.println("Не удалось найти строку поиска");
            throw new NullPointerException(e.getMessage());
        }
    }

    public void titleCheck(String cityName) {
        Assert.assertEquals("Прогноз погоды в " + cityName + " на 10 дней — Яндекс.Погода", driver.getTitle());
        System.out.println("Title соответствует ожидаемому результату");
    }

    public void getPage(String pageAddress) {
        driver.get(pageAddress);
    }

    public void switchRegion(String inputString) {
        WebElement q = getSearch();
        q.sendKeys(inputString);
        q.sendKeys(Keys.RETURN);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.regionChoose(inputString);
    }

    public LoginPage loginClick() {
        clickOnElementByLocator(loginButton, driver);
        Assert.assertEquals(driver.getTitle(), "Авторизация");
        return new LoginPage(driver);
    }

    public void loginCheck() {
        Assert.assertTrue(!isElementExist(loginButton, driver));
    }

    public void regionBlockLinkClick() {
        clickOnElementByLocator(moscowRegionLink, driver);
    }

    public void weatherOnMapGraphicTemperatureButtonClick() {
        try{
            WebElement weatherOnMapGraphicTemperatureButtonInput = findOnElementByLocator(weatherOnMapGraphicTemperatureButtonInputLocator, driver);
            WebElement weatherOnMapGraphicTemperatureButton = weatherOnMapGraphicTemperatureButtonInput.findElement(By.xpath(".."));
            scrollToElement(weatherOnMapGraphicTemperatureButton, driver);
            clickOnElement(weatherOnMapGraphicTemperatureButton);
        } catch (NullPointerException e) {
            System.out.println("Не удалось нажать на селектор в блоке графического выбора режима отображения");
            throw new NullPointerException(e.getMessage());
        }
    }

    public void checkIfTemperatureMapIsOpen() {
        Assert.assertTrue(isElementExist(temperatureMapLabel, driver));
    }

    public MonthlyForecastPage monthlyForecastLinkClick() {
        clickOnElementByLocator(monthlyForecastLink, driver);
        return new MonthlyForecastPage(driver);
    }

    public TenDaysForecastPage tenDaysForecastLinkClick() {
        clickOnElementByLocator(tenDaysForecastLink, driver);
        return new TenDaysForecastPage(driver);
    }
}
