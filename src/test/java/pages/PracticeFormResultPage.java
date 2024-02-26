package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormResultPage {
    public SelenideElement studentNameLabel = $(".table-responsive").$(byText("Student Name")).parent();
    public SelenideElement studentEmailLabel = $(".table-responsive").$(byText("Student Email")).parent();
    public SelenideElement genderLabel = $(".table-responsive").$(byText("Gender")).parent();
    public SelenideElement mobileLabel = $(".table-responsive").$(byText("Mobile")).parent();
    public SelenideElement dateOfBirthLabel = $(".table-responsive").$(byText("Date of Birth")).parent();
    public SelenideElement subjectsLabel = $(".table-responsive").$(byText("Subjects")).parent();
    public SelenideElement hobbiesLabel = $(".table-responsive").$(byText("Hobbies")).parent();
    public SelenideElement pictureLabel = $(".table-responsive").$(byText("Picture")).parent();
    public SelenideElement addressLabel = $(".table-responsive").$(byText("Address")).parent();
    public SelenideElement stateAndCityLabel = $(".table-responsive").$(byText("State and City")).parent();


    public void checkResults(
            String expectedName,
            String expectedEmail,
            String expectedGender,
            String expectedMobile,
            String expectedDateOfBirth,
            String expectedSubjects,
            String expectedHobbies,
            String expectedPicture,
            String expectedAddress,
            String expectedStateAndCity
    ) {
        checkValueByLabel(studentNameLabel, expectedName);
        checkValueByLabel(studentEmailLabel, expectedEmail);
        checkValueByLabel(genderLabel, expectedGender);
        checkValueByLabel(mobileLabel, expectedMobile);
        checkValueByLabel(dateOfBirthLabel, expectedDateOfBirth);
        checkValueByLabel(subjectsLabel, expectedSubjects);
        checkValueByLabel(hobbiesLabel, expectedHobbies);
        checkValueByLabel(pictureLabel, expectedPicture);
        checkValueByLabel(addressLabel, expectedAddress);
        checkValueByLabel(stateAndCityLabel, expectedStateAndCity);
    }


    private void checkValueByLabel(SelenideElement element, String expectedText) {
        element.shouldHave(text(expectedText));
    }











}
