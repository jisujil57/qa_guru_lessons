package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SauceDemoPage {
    private final SelenideElement loginInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement errorText = $x("//h3[@data-test='error']");
    private final SelenideElement authorizedPageNameText = $(byTagAndText("span", "Products"));

    public SauceDemoPage setLogin(String login){
        loginInput.setValue(login);
        return this;
    }

    public SauceDemoPage setPassword(String password){
        passwordInput.setValue(password);
        return this;
    }

    public SauceDemoPage authorize(){
        loginButton.click();
        return this;
    }

    public void checkPageName(){
        authorizedPageNameText.shouldHave(text("Products"));
    }

    public void checkErrorMessage(String expectedMessage){
        errorText.shouldHave(text(expectedMessage));
    }
}
