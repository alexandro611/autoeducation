import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.security.Key;
@Epic("Бродилка")
public class ExapmleTest extends BaseSetUp{


    @Test
    public void testO(){

        driver.get("https://www.rambler.ru/");
        driver.findElement(By.xpath("//span[text()=\"Новости\"]")).click();
    }

    @Test
    public void testSearch() throws InterruptedException {

        driver.get("https://www.rambler.ru/");
        driver.findElement(By.name("query")).click();
        driver.findElement(By.name("query")).sendKeys("Котики");
        driver.findElement(By.name("query")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);


    }
}
