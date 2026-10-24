import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserPropertiesTests {
    @Test
    void test_browser_properties() {
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().setSize(new Dimension(1500, 500));
        driver.manage().window().setPosition(new Point(100, 200));
        driver.get("https://ya.ru");
        driver.manage().window().maximize();

        driver.quit();
    }
}