import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SauceDemoTests {

    @Test
    void test01_login_success_saucedemo() {
        open("https://www.saucedemo.com/");

        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        // Проверяем, что попали на страницу с товарами (появился заголовок)
        $(".title").shouldHave(text("Products"));
    }

    @Test
    void test02_login_wrong_password_saucedemo() {
        open("https://www.saucedemo.com/");

        $("#user-name").setValue("standard_user");
        $("#password").setValue("wrong_password");
        $("#login-button").click();

        // Проверяем, что появилось сообщение об ошибке
        $("h3[data-test='error']").shouldBe(visible);
    }
}
