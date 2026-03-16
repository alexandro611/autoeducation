import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

@Epic("Бродилка")
public class ExampleTest extends BaseSetUp{

    @DisplayName("Открыть новости")
    @Test
    public void testO(){

        openRambler();
        driver.findElement(By.xpath("//span[text()=\"Новости\"]")).click();
        justOk();

    }
    @DisplayName("Найти котиков")
    @Test
    public void testSearch() throws InterruptedException {

        openRambler();
        driver.findElement(By.name("query")).click();
        driver.findElement(By.name("query")).sendKeys("Котики");
        driver.findElement(By.name("query")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        justOk();

    }
    @Step("Всё хорошо")
    public void openRambler(){
        driver.get("https://www.rambler.ru/");
        Allure.step("Главная страница открыта");
    }
    @Step("Всё хорошо")
    public void justOk(){
        Allure.step("Страница проверена");
    }

}
