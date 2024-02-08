package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {
    SelenideElement firstNameInput = $x("//input[@placeholder='First Name']");
    SelenideElement lastNameInput = $x("//input[@placeholder='Last Name']");
    SelenideElement emailInput = $x("//input[@placeholder='name@example.com']");
    SelenideElement phoneNumberInput = $x("//input[@placeholder='Mobile Number']");
    SelenideElement datePickerInput = $("#dateOfBirthInput");
    SelenideElement dayInput = $x("//*[@id='subjectsContainer']");
    SelenideElement subjectInput = $("#subjectsInput");




    public PracticeFormPage fillFirstName (String firstName) {
        firstNameInput.shouldHave(Condition.visible).setValue(firstName);
        return this;

    }

    public PracticeFormPage fillLastName (String lastName) {
        lastNameInput.setValue(lastName);
        return this;

    }

    public PracticeFormPage fillEmail (String email) {
        emailInput.setValue(email);
        return this;

    }

    public PracticeFormPage selectGender (String gender) {
        //Ищем инпут радиобаттн с значениями Male Female Other, ищем рядомстоящий label
        $x("//input[@type='radio'][@value='" + gender + "']/..//label").click();
        return this;

    }

    public PracticeFormPage fillPhoneNumber (String number) {
        //Ищем инпут радиобаттн с значениями Male Female Other, ищем рядомстоящий label
        phoneNumberInput.setValue(number);
        return this;

    }

    public PracticeFormPage setDate () {
        datePickerInput.click();
        dayInput.click();
        return this;

    }

    public PracticeFormPage setSubject (String subject) {
        subjectInput.setValue(subject);
        $("#react-select-2-option-0").shouldBe(Condition.visible).click();
        return this;

    }

    public PracticeFormPage setHobbies (String hobby) {
        $x("//label[contains(text(),'" + hobby + "')]").click();
        return this;

    }

    public PracticeFormPage uploadPicture (String hobbyFilePath) {
        $("#uploadPicture").uploadFile(new File(hobbyFilePath));
        return this;

    }

    public PracticeFormPage fillCurrentAddress (String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;

    }

    public PracticeFormPage selectState () {
        $("#state").click();
        $("#react-select-3-option-0").click();
        return this;

    }

    public PracticeFormPage selectCity () {
        $("#city").click();
        $("#react-select-4-option-0").click();
        return this;

    }

    public void submitForm () {
        $("#submit").click();
    }
}
