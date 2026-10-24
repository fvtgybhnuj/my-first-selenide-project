import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTests {

    @Test
    void test01_login_success() {
        open("https://slqamsk.github.io/cases/slflights/v01/");

        // Вводим данные
        $("#username").setValue("standard_user"); // Используем CSS-селектор по id (решетка #)
        $("#password").setValue("stand_pass1");  // <--- ПРОВЕРЬ ПАРОЛЬ ЗДЕСЬ
        $("#loginButton").click();

        // Проверка
        $("#logoutButton").shouldBe(visible);

        // текст приветствия
        $("#greeting").shouldHave(text("Добро пожаловать"));
    }

    @Test
    void test02_login_wrong_password() {
        open("https://slqamsk.github.io/cases/slflights/v01/");

        $("#username").setValue("standard_user");
        $("#password").setValue("wrong_password_123"); // Неверный пароль
        $("#loginButton").click();

        // Проверка: появился блок с сообщением об ошибке (id="message")
        // Проверяем, что он не пустой (содержит какой-то текст)
        $("#message").shouldNotBe(empty);

           }

    // (*) Дополнительный тест: пустой пароль (из задания со звездочкой)
    @Test
    void test03_login_empty_password() {
        open("https://slqamsk.github.io/cases/slflights/v01/");

        $("#username").setValue("standard_user");
        // Поле пароля оставляем пустым
        $("#loginButton").click();

        // Поле ввода обязательное (атрибут required в HTML),
        // браузер должен выдать нативную подсказку или сайт покажет ошибку в #message
        $("#message").shouldNotBe(empty);
    }
}
