package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.CheckBoxPage;

public class CheckBoxTest  extends BaseTest {

    private CheckBoxPage checkBoxPage; //объявили переменную со страницей для работы

    /**
     * метод будет выполняться перед всеми тестовыми методами
     * Дали драйвер для страницы
     */
    @BeforeClass
    public void setup(){
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void step_01(){
        checkBoxPage.openCheckBoxPage(); //открываем страницу
        Assert.assertEquals(checkBoxPage.getPageName(), "Check Box"); //проверяем,что открылась нужная страница
    }

    @Test
    public void step_02(){
        checkBoxPage.openListCheckBox("Home"); //нажать кнопку и выбрать хоум
        checkBoxPage.setCheckBox("Desktop", true); //выбрать десктоп
        Assert.assertTrue(checkBoxPage.getCheckBoxState("Desktop")); //проверить десктоп
    }
}
