package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private static final By NAME_PAGE = By.xpath("//h1[@class='text-center']"); /*общий xpath*/

    /**
     * Перейти по url
     * @param url ссылка в виде строки
     */

    public void openUrl(String url){
        driver.get(url);
    }

/**
 * Найти элемент на странице
 * @param locator путь до элемента, тип - By
 * @return element найденный элемент
 * */
    public WebElement findElement(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        return element;
    }

    /**
     * Найти несколько вэб элементов на странице
     * */
    public List<WebElement> findElements(String locator){
        return driver.findElements(By.xpath(locator));
    }

    /**
     * Метод для получения текста
     * */
    public String getText(By locator){
        return findElement(locator).getText();
    }

    /**
     * Метод для возвращения строки заголовка страницы
     */
    public String getPageName(){
        return getText(NAME_PAGE);
    }

    /**
     * Метод для возвращения TRUE/FALSE нажатие чек-бокса
     */
    public boolean isElementEnabled(By locator){
        return findElement(locator).isEnabled();
    }

    /**
     * Метод для очистки поля
     */
    public void clear(By locator){
        findElement(locator).clear();
    }

    /**
     * Метод для внесения значения
     */
    public void sendKeys(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    /**
     * Метод для того чтобы нажать
     */
    public void click(By locator){
        findElement(locator).click();
    }

    /**
     * Метод для возвращения TRUE/FALSE отображения элемента
     */
    public boolean isElementDisplay(By locator){
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Метод ожидания элемента несколько секунд, пока ожидаемый элемент не появится
     */
    public void waitElementIsDisplay(By locator, int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(driver1 -> isElementDisplay(locator));
    }
}
