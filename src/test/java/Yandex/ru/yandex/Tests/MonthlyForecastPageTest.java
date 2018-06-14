package Yandex.ru.yandex.Tests;

import Yandex.ru.yandex.Pages.HomePage;
import Yandex.ru.yandex.Pages.MonthlyForecastPage;
import Yandex.ru.yandex.Util.WebDriverSetUp;
import org.junit.Test;

public class MonthlyForecastPageTest extends WebDriverSetUp {

    @Test
    public void monthlyForecastTest() {
        HomePage homePage = new HomePage(driver);
        homePage.switchRegion("москва");
        homePage.regionBlockLinkClick();
        MonthlyForecastPage monthlyForecastPage = homePage.monthlyForecastLinkClick();
        monthlyForecastPage.checkIfPageOpen("Москве");
        monthlyForecastPage.pageContentCheck();
    }
}
