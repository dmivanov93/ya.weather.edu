package Yandex.ru.yandex.Tests;

import Yandex.ru.yandex.Pages.HomePage;
import Yandex.ru.yandex.Pages.TenDaysForecastPage;
import Yandex.ru.yandex.Util.WebDriverSetUp;
import org.junit.Test;

public class TenDaysForecastTest extends WebDriverSetUp {

    @Test
    public void tenDaysForecastTest() {
        HomePage homePage = new HomePage(driver);
        TenDaysForecastPage tenDaysForecastPage = homePage.tenDaysForecastLinkClick();
        tenDaysForecastPage.pageCheckContent();
        tenDaysForecastPage.headerBannerLabelCheck();
    }
}
