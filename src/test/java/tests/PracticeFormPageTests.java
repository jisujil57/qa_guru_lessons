package tests;

import com.codeborne.selenide.Selenide;
import helpers.RandomDataGenerator;
import org.junit.jupiter.api.*;
import pages.PracticeFormPage;
import pages.PracticeFormResultPage;

import static helpers.PageUrls.AUTOMATION_PRACTICE_FORM_ENDPOINT;
import static helpers.PageUrls.DEMO_QA_BASE_URL;

@DisplayName("Проверка automation-practice-form")
public class PracticeFormPageTests extends BaseTest {
    @BeforeEach
    void setUp() {
        Selenide.open(DEMO_QA_BASE_URL + AUTOMATION_PRACTICE_FORM_ENDPOINT);
    }

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    PracticeFormResultPage resultPage = new PracticeFormResultPage();

    @Test
    @DisplayName("Корректное заполнение всех полей")
    void submitFormTest() {
        practiceFormPage.removeBanner();

        String firstName = RandomDataGenerator.randomFirstName();
        String lastName = RandomDataGenerator.randomLastName();
        String email = RandomDataGenerator.randomEmail();
        String gender = RandomDataGenerator.randomGender();
        String phoneNumber = RandomDataGenerator.randomPhone();
        String year = RandomDataGenerator.randomYear();
        String month = RandomDataGenerator.randomMonth();
        String day = RandomDataGenerator.randomDay();
        String subject = RandomDataGenerator.randomSubject();
        String hobby = RandomDataGenerator.randomHobby();
        String pictureName = RandomDataGenerator.randomPictureName();
        String address = RandomDataGenerator.randomAddress();
        String state = RandomDataGenerator.randomState();
        String city = RandomDataGenerator.randomCity(state);

        practiceFormPage.fillFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(pictureName)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        resultPage.checkTableValue("Student Name", firstName + " " + lastName)
                .checkTableValue("Student Email", email)
                .checkTableValue("Gender", gender)
                .checkTableValue("Mobile", phoneNumber)
                .checkTableValue("Date of Birth", String.format("Date of Birth %02d %s,%s",
                        Integer.parseInt(day), month, year))
                .checkTableValue("Subjects", subject)
                .checkTableValue("Hobbies", hobby)
                .checkTableValue("Picture", pictureName)
                .checkTableValue("Address", address)
                .checkTableValue("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Корректное заполнение обязательных полей")
    void submitFormWithRequiredFieldsTest() {
        String firstName = RandomDataGenerator.randomFirstName();
        String lastName = RandomDataGenerator.randomLastName();
        String gender = RandomDataGenerator.randomGender();
        String phoneNumber = RandomDataGenerator.randomPhone();

        practiceFormPage.fillFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .submitForm();

        resultPage.checkTableValue("Student Name", firstName + " " + lastName)
                .checkTableValue("Gender", gender)
                .checkTableValue("Mobile", phoneNumber);
    }

    @Test
    @DisplayName("Отправка незаполненных полей")
    void submitFormWithRequired() {
        practiceFormPage.submitForm();
        resultPage.checkModalHiddenAfterInvalidFormSubmit();
    }
}

