package Yandex.ru.yandex.Util;

import org.junit.Assert;
import org.openqa.selenium.*;
import java.util.List;

public class CommonMethods {
    public static void clickOnElement(WebElement element) {
        try {
            element.click();
            System.out.println("Выполнено нажатие на элемент " + element);
        } catch (NullPointerException e) {
            System.out.println("Не удалось нажать на элемент " + element);
            throw new NullPointerException(e.getMessage());
        }
    }

    public static void clickOnElementByLocator(By locator, WebDriver driver) {
        try {
            findOnElementByLocator(locator, driver).click();
            System.out.println("Выполнено нажатие на элемент с локатором " + locator);
        } catch (NullPointerException e) {
            System.out.println("Не удалось нажать на элемент с локатором " + locator);
            throw new NullPointerException(e.getMessage());
        }
    }

    public static String firstLetterToUpperCase(String string) {
        if (string != null)
            return string.substring(0, 1).toUpperCase() +
                    string.substring(1);
        else
            return "";
    }

    public static boolean isElementExist(By locator, WebDriver driver) {
        try{
            return driver.findElement(locator).isDisplayed();
        }
        catch (NoSuchElementException e) {
            System.out.println("Элемент с локатором " + locator + " не отображается");
            return false;
        }
    }

    public static boolean isElementExist(WebElement element) {
        try{
            return element.isDisplayed();
        }
        catch (NoSuchElementException e) {
            System.out.println("Элемент " + element + " не отображается");
            return false;
        }
    }

    public static void scrollToElement(WebElement element, WebDriver driver) {
        try {
            int scrollTo = element.getLocation().getY() - (driver.manage().window().getSize().getHeight() / 2);
            ((JavascriptExecutor) driver).executeScript( "window.scrollTo(0, " + scrollTo + ");");
            System.out.println("Выполнен скролл до элемента " + element);
        } catch (Exception e) {
            System.out.println("Не удалось выполнить скролл: не найден элемент: " + element);
        }
    }

    public static void contentCheck(List<By> locators, WebDriver driver) {
        for (By locator: locators)
        {
            try {
                Assert.assertTrue(isElementExist(locator, driver));
                System.out.println("Элемент с локатором " + locator + " отображается");
            } catch (NullPointerException e){
                System.out.println("Элемент с локатором " + locator + " не найден");
                throw new NullPointerException(e.getMessage());
            }
        }
    }

    public static void contentCheck(List<WebElement> elements) {
        for (WebElement element: elements)
        {
            try {
                Assert.assertTrue(isElementExist(element));
                System.out.println("Элемент " + element + " отображается");
            } catch (NullPointerException e){
                System.out.println("Элемент " + element + " не найден");
                throw new NullPointerException(e.getMessage());
            }
        }
    }

    public static WebElement findOnElementByLocator(By locator, WebDriver driver) {
        WebElement element;
        try {
            element = driver.findElement(locator);
            System.out.println("Найден элемент с локатором " + locator);
            return element;
        } catch (NullPointerException e) {
            System.out.println("Найден элемент с локатором " + locator);
            return null;
        }
    }
}
