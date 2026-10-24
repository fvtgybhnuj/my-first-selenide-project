import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    // Локаторы
    private SelenideElement logoutButton = $("#logoutButton");
    private SelenideElement greetingText = $("#greeting");

    // Проверки
    public SelenideElement getLogoutButton() {
        return logoutButton;
    }

    public SelenideElement getGreetingText() {
        return greetingText;
    }
}
