package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.PracticeFormPage;
import pages.PracticeFormResultPage;

import static helpers.PageUrls.AUTOMATION_PRACTICE_FORM_ENDPOINT;
import static helpers.PageUrls.DEMO_QA_BASE_URL;

public class PracticeFormPageTests extends BaseTest {
    @BeforeAll
    static void beforeAll() {
        setUpBrowser();
    }

    @BeforeEach
    void setUp() {
        Selenide.open(DEMO_QA_BASE_URL + AUTOMATION_PRACTICE_FORM_ENDPOINT);
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    PracticeFormResultPage resultPage = new PracticeFormResultPage();


    @Test
    void submitFormTest() {

        String picturePath = "src/test/resources/img.png";
        String firstName = "asfasfasf";
        String lastName = "asfasfasf";
        String email = "asfasfasf@asasd.ew";
        String gender = "Male";
        String phoneNumber = "9995552211";
        String subject = "Arts";
        String[] hobbies = {"Sport", "Reading", "Music"};
        String address = "Россия, г. Странный, ул. Илоны, д. 114";

        practiceFormPage.fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .selectGender(gender)
                .fillPhoneNumber(phoneNumber)
                .setDate()
                .setSubject(subject)
                .setHobbies(hobbies[0])
                .setHobbies(hobbies[1])
                .setHobbies(hobbies[2])
                .uploadPicture(picturePath)
                .fillCurrentAddress(address)
                .selectState()
                .selectCity()
                .submitForm();

        Assertions.assertEquals(email, resultPage.studentEmailResult.shouldBe(Condition.visible).getText());
        Assertions.assertEquals(subject, resultPage.subjectsResult.shouldBe(Condition.visible).getText());

    }
}
