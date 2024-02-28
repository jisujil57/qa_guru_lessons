package tests;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GItHubTest extends BaseTest{

    String testedText = "public class Tests {\n" +
            "  @Test\n" +
            "  public void test() {\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void checkSoftAssertionsPageTest() {

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byId("wiki-pages-box")).$(byText("Show 3 more pages…")).click();
        $(byTagAndText("a", "SoftAssertions")).click();
        $(".markdown-body").shouldHave(text(testedText)).shouldBe(visible);

    }

    @Test
    void checkGitHubNavBar() {

        open("https://github.com");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(byTagAndText("h1", "The AI-powered")).shouldBe(visible);

    }
}
