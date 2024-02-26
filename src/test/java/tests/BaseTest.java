package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        setUpBrowser();
    }

    public static void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 4000;
        Configuration.pageLoadStrategy = "eager";

    }

}
