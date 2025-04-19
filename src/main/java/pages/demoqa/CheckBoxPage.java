package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
/**
 * наследуемся от BasePage и будем его дополнять
 */
public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    private static final String URL_CHECK_BOX_PAGE = "https://demoqa.com/checkbox";

    /**
     * найти инпут чек-бокса
     */
    private static final String CHECK_BOX_INPUT_XPATH = "//input[@type='checkbox'][following-sibling::span[text()='%s']]";

    /**
     * найти баттон тогл
     */
    public static final String BUTTON_TOGGLE = CHECK_BOX_INPUT_XPATH + "/../preceding-sibling::button[@title='Toggle']";

    /**
     * найти путь до чек-бокса, на который нужно нажать
     */
    private static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/following-sibling::span[@class='rct-checkbox']";


    public void openCheckBoxPage(){
        openUrl(URL_CHECK_BOX_PAGE);
    }

    /**
     * Получить состояние чек-бокса по его названию
     */
    public boolean getCheckBoxState(String checkBoxName){
        return findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH, checkBoxName))).isSelected();
    }

    /**
     * Метод,который переводит чек-бокс в какое-либо состояние
     */
    public void setCheckBox(String checkBoxName, boolean state) {
        if (!getCheckBoxState(checkBoxName) == state){
        click(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName)));
        }
    }

    public boolean isCheckBoxDisplay(String checkBoxName){
        return isElementDisplay(By.xpath(String.format(CHECK_BOX_XPATH, checkBoxName)));
    }

    /**
     * Метод,который нажимает на баттон и раскрывает список вложенных элементов
     */
    public void openListCheckBox(String checkBoxName){
        if (isCheckBoxDisplay(checkBoxName)){
            click(By.xpath(String.format(BUTTON_TOGGLE, checkBoxName)));
        }
    }

}
