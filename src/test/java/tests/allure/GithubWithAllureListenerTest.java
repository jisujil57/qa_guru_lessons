package tests.allure;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static helpers.PageUrls.GITHUB_BASE_URL;

@DisplayName("Отображение Issues в репозитории (Listener)")
public class GithubWithAllureListenerTest extends BaseTest {
    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Отображение Issues")
    @ParameterizedTest(name = "Поисковый запрос: {0}, Issues: {2}")
    @CsvSource({
            "selenide, /selenide/selenide, User can add a global proxy filter",
            "allure, /allure-framework/allure2, Group by",
    })
    void checkIssueNameInGithub(String searchQuery, String repositoryLink, String expectedIssuesName) {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open(GITHUB_BASE_URL);
        $(".search-input").click();
        $("#query-builder-test").setValue(searchQuery).submit();
        $("[href='" + repositoryLink + "']").click();
        $("#issues-tab").click();
        $(withTagAndText("a", expectedIssuesName)).shouldHave(text(expectedIssuesName));
    }
}
