package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.SauceDemoPage;
import java.util.stream.Stream;
import static helpers.PageUrls.SAUCE_DEMO_BASE_URL;

@DisplayName("Тестирование авторизации https://www.saucedemo.com/")
public class SauceDemoTest extends BaseTest {

    private SauceDemoPage sauceDemoPage;
    String defaultPassword = "secret_sauce";
    String defaultUserName = "standard_user";

    @BeforeEach
    void setUp() {
        Selenide.open(SAUCE_DEMO_BASE_URL);
        sauceDemoPage = new SauceDemoPage();
    }

    static Stream<Arguments> validCredentialsProvider() {
        return Stream.of(
                Arguments.of("standard_user"),
                Arguments.of("problem_user"),
                Arguments.of("visual_user")
        );
    }

    @ParameterizedTest(name = "Успешная авторизация с именем пользователя: {0}")
    @DisplayName("Успешная авторизация")
    @MethodSource("validCredentialsProvider")
    void successfulUserAuthorization(String username) {
        sauceDemoPage
                .setLogin(username)
                .setPassword(defaultPassword)
                .authorize()
                .checkPageName();
    }

    @ParameterizedTest(name = "Пароль: {0}")
    @DisplayName("Ввод некорректного пароля")
    @ValueSource(strings = {"asdasdasf", "3464g2rgsdfg", "2435f"})
    void incorrectUserPassword(String password) {
        sauceDemoPage
                .setLogin(defaultUserName)
                .setPassword(password)
                .authorize()
                .checkErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @ParameterizedTest(name = "Логин: {0}, Пароль: {1}")
    @DisplayName("Ввод некорректных логина и пароля")
    @CsvFileSource(resources = "/csv/user_credentials.csv")
    void incorrectUserLoginAndPassword(String login, String password, String errorMessage) {
        sauceDemoPage
                .setLogin(login)
                .setPassword(password)
                .authorize()
                .checkErrorMessage(errorMessage);
    }
}
