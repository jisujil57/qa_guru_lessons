package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import pages.TextBoxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static helpers.PageUrls.DEMO_QA_BASE_URL;
import static helpers.PageUrls.TEXT_BOX_FORM_ENDPOINT;

@DisplayName("Проверка text-box-form")
public class TextBoxTest extends BaseTest {
    @BeforeEach
    void setUp() {
        Selenide.open(DEMO_QA_BASE_URL + TEXT_BOX_FORM_ENDPOINT);
    }

    TextBoxPage textBoxPage = new TextBoxPage();

    String name = "Kaka Ronaldo Karlson";
    String email = "tester@mail.wew";
    String currentAdress = "88473 Spencer Port, New Donnetta, TX 29597-9376";
    String permanentAddress = "Apt. 583 7706 Grimes Wall, Sawaynport, WI 41742-3645";

    @Test
    @DisplayName("Корректное заполнение полей")
    void fillTextBoxForm() {
        textBoxPage.setUserName(name)
                .setEmail(email)
                .setCurrentAddress(currentAdress)
                .setPermanentAddress(permanentAddress)
                .submit();
        Selenide.sleep(2000);

        textBoxPage.checkTableValue("name", name)
                .checkTableValue("email", email)
                .checkTableValue("currentAddress", currentAdress)
                .checkTableValue("permanentAddress", permanentAddress);
    }
}
