package Yandex.ru.yandex.Tests;

import Yandex.ru.yandex.Pages.HomePage;
import Yandex.ru.yandex.Util.WebDriverSetUp;
import org.junit.Test;

public class WeatherOnMapGraphicBlockTest extends WebDriverSetUp {

    @Test
    public void weatherOnMapGraphicBlockTest() {
        HomePage homePage = new HomePage(driver);
        homePage.weatherOnMapGraphicTemperatureButtonClick();
        homePage.checkIfTemperatureMapIsOpen();
    }
}
