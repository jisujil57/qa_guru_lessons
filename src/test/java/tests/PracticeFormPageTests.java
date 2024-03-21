package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import helpers.RandomDataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;
import pages.PracticeFormResultPage;

import java.util.Map;

import static helpers.PageUrls.AUTOMATION_PRACTICE_FORM_ENDPOINT;
import static helpers.PageUrls.DEMO_QA_BASE_URL;

@DisplayName("Проверка automation-practice-form")
public class PracticeFormPageTests extends BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @BeforeEach
    void setUp() {
        Selenide.open(DEMO_QA_BASE_URL + AUTOMATION_PRACTICE_FORM_ENDPOINT);
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();

    }

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    PracticeFormResultPage resultPage = new PracticeFormResultPage();
    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    @Test
    @Tag("smoke_test")
    @DisplayName("Корректное заполнение всех полей")
    void submitFormTest() {
        practiceFormPage.removeBanner();

        String firstName = randomDataGenerator.randomFirstName();
        String lastName = randomDataGenerator.randomLastName();
        String email = randomDataGenerator.randomEmail();
        String gender = randomDataGenerator.randomGender();
        String phoneNumber = randomDataGenerator.randomPhone();
        String year = randomDataGenerator.randomYear();
        String month = randomDataGenerator.randomMonth();
        String day = randomDataGenerator.randomDay();
        String subject = randomDataGenerator.randomSubject();
        String hobby = randomDataGenerator.randomHobby();
        String pictureName = randomDataGenerator.randomPictureName();
        String address = randomDataGenerator.randomAddress();
        String state = randomDataGenerator.randomState();
        String city = randomDataGenerator.randomCity(state);

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
        String firstName = randomDataGenerator.randomFirstName();
        String lastName = randomDataGenerator.randomLastName();
        String gender = randomDataGenerator.randomGender();
        String phoneNumber = randomDataGenerator.randomPhone();

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

