package tests;

import com.codeborne.selenide.Selenide;
import helpers.RandomDataGenerator;
import org.junit.jupiter.api.*;
import pages.TextBoxPage;

import static helpers.PageUrls.DEMO_QA_BASE_URL;
import static helpers.PageUrls.TEXT_BOX_FORM_ENDPOINT;

@DisplayName("Проверка text-box-form")
public class TextBoxTest extends BaseTest {
    @BeforeEach
    void setUp() {
        Selenide.open(DEMO_QA_BASE_URL + TEXT_BOX_FORM_ENDPOINT);
    }

    TextBoxPage textBoxPage = new TextBoxPage();
    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
    String name = randomDataGenerator.randomFullName();
    String email = randomDataGenerator.randomEmail();
    String currentAdress = randomDataGenerator.randomAddress();
    String permanentAddress = randomDataGenerator.randomAddress();

    @Test
    @DisplayName("Корректное заполнение полей")
    void fillTextBoxForm() {
        textBoxPage.setUserName(name)
                .setEmail(email)
                .setCurrentAddress(currentAdress)
                .setPermanentAddress(permanentAddress)
                .submit();

        textBoxPage.checkTableValue("name", name)
                .checkTableValue("email", email)
                .checkTableValue("currentAddress", currentAdress)
                .checkTableValue("permanentAddress", permanentAddress);
    }
}
