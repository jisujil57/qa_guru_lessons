package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.CalendarComponents;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    SelenideElement firstNameInput = $x("//input[@placeholder='First Name']");
    SelenideElement lastNameInput = $x("//input[@placeholder='Last Name']");
    SelenideElement emailInput = $x("//input[@placeholder='name@example.com']");
    SelenideElement phoneNumberInput = $x("//input[@placeholder='Mobile Number']");
    SelenideElement datePickerInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");

    @Step("Заполнить имя")
    public PracticeFormPage fillFirstName(String firstName) {
        firstNameInput.shouldHave(Condition.visible).setValue(firstName);
        return this;
    }

    @Step("Заполнить фамилию")
    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Указать email")
    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Выбрать пол")
    public PracticeFormPage setGender(String gender) {
        $x("//input[@type='radio'][@value='" + gender + "']/..//label").click();
        return this;
    }

    @Step("Указать номер телефона")
    public PracticeFormPage setPhoneNumber(String number) {
        phoneNumberInput.setValue(number);
        return this;
    }

    @Step("Выбрать дату рождения")
    public PracticeFormPage setDate(String day, String month, String year) {
        datePickerInput.click();
        new CalendarComponents().setDate(day, month, year);
        return this;
    }

    @Step("Выбрать предмет")
    public PracticeFormPage setSubject(String subject) {
        subjectInput.setValue(subject);
        $("#react-select-2-option-0").shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Выбрать хобби")
    public PracticeFormPage setHobbies(String hobby) {
        $x("//label[contains(text(),'" + hobby + "')]").click();
        return this;
    }

    @Step("Загрузить изображение")
    public PracticeFormPage uploadPicture(String pictureName) {
        $("#uploadPicture").uploadFromClasspath(pictureName);
        return this;
    }

    @Step("Указать текущий адрес")
    public PracticeFormPage setCurrentAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    @Step("Выбрать штат")
    public PracticeFormPage setState(String state) {
        $("#state").click();
        $x("//div[@class=' css-11unzgr']//div[contains(text(), '" + state + "')]").click();
        return this;
    }

    @Step("Выбрать город")
    public PracticeFormPage setCity(String city) {
        $("#city").click();
        $x("//div[@class=' css-11unzgr']//div[contains(text(), '" + city + "')]").click();
        return this;
    }

    @Step("Отправить форму")
    public void submitForm() {
        $("#submit").click();
    }

    public void removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
