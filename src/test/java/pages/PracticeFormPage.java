package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {
    SelenideElement firstNameInput = $x("//input[@placeholder='First Name']");
    SelenideElement lastNameInput = $x("//input[@placeholder='Last Name']");
    SelenideElement emailInput = $x("//input[@placeholder='name@example.com']");

    public PracticeFormPage fillFirstName() {
        firstNameInput.shouldHave(Condition.visible).setValue("asdasf");
        return this;
    }

    public PracticeFormPage fillLastName() {
        firstNameInput.shouldHave(Condition.visible).setValue("asdasf");
        return this;
    }

    public PracticeFormPage fillEmail() {
        firstNameInput.shouldHave(Condition.visible).setValue("asdasf");
        return this;
    }


}
