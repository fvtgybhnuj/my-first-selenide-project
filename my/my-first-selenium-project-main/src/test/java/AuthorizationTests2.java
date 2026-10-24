import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;

public class AuthorizationTests2 {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    void test01_login_success() {
        loginPage.openPage().login("standard_user", "stand_pass1");

        // Проверка на MainPage
        mainPage.getLogoutButton().shouldBe(visible);
        mainPage.getGreetingText().shouldHave(text("Добро пожаловать"));
    }

    @Test
    void test02_login_wrong_password() {
        loginPage.openPage().login("standard_user", "wrong_password_123");

        // Проверка на LoginPage
        loginPage.getErrorMessage().shouldNotBe(empty);
    }

    @Test
    void test03_login_empty_password() {
        loginPage.openPage().login("standard_user", "");

        loginPage.getErrorMessage().shouldNotBe(empty);
    }
}