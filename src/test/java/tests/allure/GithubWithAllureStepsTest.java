package tests.allure;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.BaseTest;

@DisplayName("Отображение Issues в репозитории (Steps)")
public class GithubWithAllureStepsTest extends BaseTest {
    GitHubSteps gitHubSteps = new GitHubSteps();

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

        gitHubSteps.open()
                .searchRepository(searchQuery)
                .openSearchedRepository(repositoryLink)
                .openIssuesPage()
                .checkIssuesName(expectedIssuesName);
    }


}
