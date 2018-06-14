package Yandex.ru.yandex.Tests;

import Yandex.ru.yandex.Pages.HomePage;
import Yandex.ru.yandex.Pages.LoginPage;
import Yandex.ru.yandex.Util.WebDriverSetUp;
import org.junit.Test;

public class LoginTest extends WebDriverSetUp {

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.loginClick();
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.clickEnter();
        homePage.loginCheck();
    }
}
