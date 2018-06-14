package Yandex.ru.yandex.Util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetUp {

    public ChromeDriver driver;

    @Before
    public void webDriverSetUp() {
        System.setProperty("webdriver.chrome.driver", "/Programs/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void driverQuit() {
//        driver.quit();
    }
}
