package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormResultPage {
    SelenideElement tableElement = $(".table-responsive");
    public PracticeFormResultPage checkTableValue(String key, String value) {

        tableElement.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void checkModalHiddenAfterInvalidFormSubmit() {
        tableElement.shouldHave(hidden);
    }


}
