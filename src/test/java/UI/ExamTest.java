package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class ExamTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testForm() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");


        WebElement textInput = driver.findElement(By.xpath("//input[@id='my-text-id']"));
        textInput.sendKeys("Терновский Илья Александрович");


        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
        textArea.sendKeys("MANCHESTER");

        // 3. Заполняем поле «Password»
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Password");

        Assert.assertEquals(textInput.getAttribute("value"), "Терновский Илья Александрович");
        Assert.assertEquals(textArea.getAttribute("value"), "MANCHESTER");
        Assert.assertEquals(password.getAttribute("value"), "Password");


        Select dropdownSelect = new Select(driver.findElement(By.xpath("//select[@name='my-select']")));
        dropdownSelect.selectByVisibleText("two");

        WebElement datalistInput = driver.findElement(By.xpath("//input[@name='my-datalist']"));
        datalistInput.sendKeys("Seattle");




        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='my-check-2']"));

        checkbox2.click();
        Assert.assertTrue(checkbox2.isSelected());


        WebElement radioButton = driver.findElement(By.xpath("//input[@class='form-check-input']"));
        radioButton.click();


        Assert.assertTrue(radioButton.isSelected());


        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();





        // Закрываем браузер после выполнения теста
        driver.quit();
    }
}