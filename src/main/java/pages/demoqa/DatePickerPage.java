package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

public class DatePickerPage extends BasePage {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_DATE_PICKER_PAGE = "https://demoqa.com/date-picker";

    public static final String SELECT_DATE_ELEMENT = "//input[@id='datePickerMonthYearInput']";

    private String dayInDataPicker(int number){
        return String.format("//div[@role='option' and text()='%s']", number); // найти день
    }

    private static final String MONTH_SELECT = "//select[contains(@class, 'month')]"; //найти месяц

    private static final String YEAR_SELECT = "//select[contains(@class, 'year')]"; //найти год

    private static final String RESULT_DATE_INPUT = "//input[@value='03/12/2024']";


    public void openDatePickerPage(){
        openUrl(URL_DATE_PICKER_PAGE); //открыть страницу с выбором даты
    }

    public void clickDatePicker(){
        click(By.xpath(SELECT_DATE_ELEMENT)); //нажать на поле ввода даты
    }

    public void selectMonth(String month){
        Select monthSelect = new Select(findElement(By.xpath(MONTH_SELECT))); //отметить месяц
        monthSelect.selectByVisibleText(month);
    }

    public void selectYear(String year){
        Select yearSelect = new Select(findElement(By.xpath(YEAR_SELECT))); //отметить год
        yearSelect.selectByVisibleText(year);
    }

    public void setDate(){
        selectYear("2024");
        selectMonth("March");
        click(By.xpath(dayInDataPicker(12))); //ввести все значения
    }

    public boolean isResultDateDisplay(){
        return isElementDisplay(By.xpath(RESULT_DATE_INPUT)); //проверить значения после ввода
    }
}
