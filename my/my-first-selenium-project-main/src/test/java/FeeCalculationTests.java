import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FeeCalculationTests {

    @Test
    void testFeeCalculationMultipleValues() {

        // --- Проверка 1: Ввод через sendKeys (сумма 10) ---
        // По условию: комиссия 1%, но не меньше 10 руб. Значит комиссия = 10, итог = 20.
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).sendKeys("10");
        $(By.name("submit")).click();

        // Проверяем, что в элементе name="com" появился текст "10"
        $("[name='com']").shouldHave(text("10"));
        $("[name='total']").shouldHave(text("20"));


        // --- Проверка 2: Ввод через setValue (сумма 1000) ---
        // 1% от 1000 = 10 руб. Итог = 1010.
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).setValue("1000"); // setValue очищает поле и сразу вставляет
        $(By.name("submit")).click();

        $("[name='com']").shouldHave(text("10"));
        $("[name='total']").shouldHave(text("1010"));


        // --- Проверка 3: Ввод через type (сумма 50000) ---
        // 1% от 50000 = 500, но максимальная комиссия 100. Значит комиссия = 100, итог = 50100.
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).type("50000"); // type вводит по одному символу (медленно)
        $(By.name("submit")).click();

        $("[name='com']").shouldHave(text("100"));
        $("[name='total']").shouldHave(text("50100"));


        // --- Проверка 4: Ввод через sendKeys (сумма 100) ---
        // 1% от 100 = 1 руб., но минимальная комиссия 10. Значит комиссия = 10, итог = 110.
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).sendKeys("100");
        $(By.name("submit")).click();

        $("[name='com']").shouldHave(text("10"));
        $("[name='total']").shouldHave(text("110"));
    }
}