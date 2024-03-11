package tests;

import com.codeborne.selenide.Selenide;
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

        String firstName = "Додо";
        String lastName = "Ивашин";
        String email = "asfasfasf@asasd.ew";
        String gender = "Male";
        String phoneNumber = "9995552211";
        String year = "2000";
        String month = "January";
        String day = "12";
        String subject = "Arts";
        String[] hobbies = {"Sport", "Reading", "Music"};
        String picturePath = "src/test/resources/img.png";
        String pictureName = picturePath.substring(picturePath.lastIndexOf("/") + 1);
        String address = "Россия, г. Странный, ул. Илоны, д. 114";
        String state = "NCR";
        String city = "Delhi";

        practiceFormPage.fillFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies[0])
                .setHobbies(hobbies[1])
                .setHobbies(hobbies[2])
                .uploadPicture(picturePath)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        resultPage.checkTableValue("Student Name", firstName + " " + lastName)
            .checkTableValue("Student Email", email)
            .checkTableValue("Gender", gender)
            .checkTableValue("Mobile", phoneNumber)
            .checkTableValue("Date of Birth", "Date of Birth " + day + " " + month + "," + year)
            .checkTableValue("Subjects", subject)
            .checkTableValue("Hobbies", hobbies[0])
            .checkTableValue("Hobbies", hobbies[1])
            .checkTableValue("Hobbies", hobbies[2])
            .checkTableValue("Picture", pictureName)
            .checkTableValue("Address", address)
            .checkTableValue("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Корректное заполнение обязательных полей")
    void submitFormWithRequiredFieldsTest() {

        String firstName = "Додо";
        String lastName = "Ивашин";
        String gender = "Male";
        String phoneNumber = "9995552211";

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
