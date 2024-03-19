package tests.allure;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static helpers.PageUrls.GITHUB_BASE_URL;

public class GitHubSteps {

    @Step("Открыть страницу GitHub")
    public GitHubSteps open() {
        Selenide.open(GITHUB_BASE_URL);
        return this;
    }

    @Step("Найти репозиторий по ключевому слову {searchQuery}")
    public GitHubSteps searchRepository(String searchQuery) {
        $(".search-input").click();
        $("#query-builder-test").setValue(searchQuery).submit();
        return this;
    }

    @Step("Открыть найденный репозиторий c названием {repositoryLink}")
    public GitHubSteps openSearchedRepository(String repositoryLink) {
        $("[href='" + repositoryLink + "']").click();
        return this;
    }

    @Step("Открыть раздел Issues")
    public GitHubSteps openIssuesPage() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверить Issues с названием {expectedIssuesName}")
    public void checkIssuesName(String expectedIssuesName) {
        $(withTagAndText("a", expectedIssuesName)).shouldHave(text(expectedIssuesName));
    }
}
