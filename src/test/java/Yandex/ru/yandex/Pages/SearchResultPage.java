package Yandex.ru.yandex.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Yandex.ru.yandex.Util.CommonMethods.*;

public class SearchResultPage {

    private WebDriver driver;

    SearchResultPage(WebDriver driver) {
        this.driver = driver;
        System.out.println("Инициализирован инстанс страницы " + this.getClass().getSimpleName());
    }

    void regionChoose(String searchRequest) {
        driver.findElement(By.partialLinkText(firstLetterToUpperCase(searchRequest))).click();
    }
}
