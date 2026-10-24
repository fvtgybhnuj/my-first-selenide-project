import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    // Локаторы
    private SelenideElement usernameInput = $("#username");
    private SelenideElement passwordInput = $("#password");
    private SelenideElement loginButton = $("#loginButton");
    private SelenideElement errorMessage = $("#message");

    // Действия
    public LoginPage openPage() {
        com.codeborne.selenide.Selenide.open("https://slqamsk.github.io/cases/slflights/v01/");
        return this;
    }

    public void login(String username, String password) {
        usernameInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
    }

    // Проверки
    public SelenideElement getErrorMessage() {
        return errorMessage;
    }
}