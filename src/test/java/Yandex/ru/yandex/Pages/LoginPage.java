package Yandex.ru.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Yandex.ru.yandex.Util.CommonMethods.*;

public class LoginPage {

    WebDriver driver;
    private By loginField = By.xpath("//input[@name='login']");
    private By passwordField = By.xpath("//input[@name='passwd']");
    private By enterButton = By.xpath("//span[@class='passport-Button-Text']");
    private By notNowButton = By.xpath("//div[@class='request-phone_back-button']/button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        System.out.println("Инициализирован инстанс страницы " + this.getClass().getSimpleName());
    }

    public void enterLogin() {
        String login = "anotherTestUser";
        try {
            driver.findElement(loginField).sendKeys(login);
            System.out.println("В поле логин введено: " + login);
        } catch (NullPointerException e) {
            System.out.println("Не удалось ввести текст в поле логин");
            throw new NullPointerException(e.getMessage());
        }
    }

    public void enterPassword() {
        String password = "admin404";
        try {
            driver.findElement(passwordField).sendKeys(password);
            System.out.println("В поле пароль введено: " + password);
        } catch (NullPointerException e) {
            System.out.println("Не удалось ввести текст в поле пароль");
            throw new NullPointerException(e.getMessage());
        }
    }

    public void clickEnter() {
        try {
            clickOnElementByLocator(enterButton, driver);
            System.out.println("Выполнено нажатие на кнопку 'Продолжить'");
        } catch (NullPointerException e) {
            System.out.println("Не удалось выполнить нажатие на кнопку 'Продолжить'");
            throw new NullPointerException(e.getMessage());
        }
    }

    public void clickNotNow() {
        try {
            clickOnElementByLocator(notNowButton, driver);
            System.out.println("Выполнено нажатие на кнопку 'Не сейчас'");
        } catch (NullPointerException e) {
            System.out.println("Не удалось выполнить нажатие на кнопку 'Не сейчас'");
            throw new NullPointerException(e.getMessage());
        }
    }
}
