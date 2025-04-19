package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.DatePickerPage;

public class DatePickerTest extends BaseTest {

    private DatePickerPage datePickerPage;

    @BeforeClass
    public void beforeClass(){
        datePickerPage = new DatePickerPage(driver);
    }

    @Test
    public void step_01(){
        datePickerPage.openDatePickerPage();
        Assert.assertEquals(datePickerPage.getPageName(), "Date Picker");
    }

    @Test
    public void step_02(){
        datePickerPage.clickDatePicker();
        datePickerPage.setDate();
        Assert.assertTrue(datePickerPage.isResultDateDisplay());
    }
}
