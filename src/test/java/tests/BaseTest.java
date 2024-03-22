package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.xmlbeans.SystemProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BaseTest {

    public final static String BROWSER_NAME = SystemProperties.getProperty("browser", "firefox");

    @BeforeAll
    static void beforeAll() {
        setUpBrowser();
    }

    public static void setUpBrowser() {
        Configuration.browser = BROWSER_NAME;
        Configuration.baseUrl = SystemProperties.getProperty("baseUrl", "https://demoqa.com");
        Configuration.browserSize = SystemProperties.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = SystemProperties.getProperty("browserVersion", "106.0");
        String selenoidUrl = System.getProperty("selenoidUrl", "https://user1:1234@selenoid.autotests.cloud");
        Configuration.remote = selenoidUrl + "/wd/hub";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
