package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponents;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    SelenideElement firstNameInput = $x("//input[@placeholder='First Name']");
    SelenideElement lastNameInput = $x("//input[@placeholder='Last Name']");
    SelenideElement emailInput = $x("//input[@placeholder='name@example.com']");
    SelenideElement phoneNumberInput = $x("//input[@placeholder='Mobile Number']");
    SelenideElement datePickerInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");


    public PracticeFormPage fillFirstName(String firstName) {
        firstNameInput.shouldHave(Condition.visible).setValue(firstName);
        return this;

    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;

    }

    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;

    }

    public PracticeFormPage setGender(String gender) {
        //Ищем инпут радиобаттн с значениями Male Female Other, ищем рядомстоящий label
        $x("//input[@type='radio'][@value='" + gender + "']/..//label").click();
        return this;

    }

    public PracticeFormPage setPhoneNumber(String number) {
        //Ищем инпут радиобаттн с значениями Male Female Other, ищем рядомстоящий label
        phoneNumberInput.setValue(number);
        return this;

    }


    public PracticeFormPage setDate(String day, String month, String year) {
        datePickerInput.click();
        new CalendarComponents().setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject);
        $("#react-select-2-option-0").shouldBe(Condition.visible).click();
        return this;

    }

    public PracticeFormPage setHobbies(String hobby) {
        $x("//label[contains(text(),'" + hobby + "')]").click();
        return this;

    }

    public PracticeFormPage uploadPicture(String pictureName) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + pictureName));
        return this;

    }

    public PracticeFormPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;

    }

    public PracticeFormPage setState(String state) {
        $("#state").click();
        $x("//div[@class=' css-11unzgr']//div[contains(text(), '" + state + "')]").click();
        return this;

    }

    public PracticeFormPage setCity(String city) {
        $("#city").click();
        $x("//div[@class=' css-11unzgr']//div[contains(text(), '" + city + "')]").click();
        return this;

    }

    public void submitForm() {
        $("#submit").click();
    }


    public void removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

}
