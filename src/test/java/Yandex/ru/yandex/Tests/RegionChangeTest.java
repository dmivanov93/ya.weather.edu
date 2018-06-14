package Yandex.ru.yandex.Tests;

import Yandex.ru.yandex.Pages.HomePage;
import Yandex.ru.yandex.Util.WebDriverSetUp;
import org.junit.Test;

public class RegionChangeTest extends WebDriverSetUp {

    @Test
    public void regionChangeTest() {
        HomePage homePage = new HomePage(driver);
        homePage.regionBlockLinkClick();
        homePage.titleCheck("Москве");
        homePage.switchRegion("вологда");
        homePage.titleCheck("Вологде");
    }


}
