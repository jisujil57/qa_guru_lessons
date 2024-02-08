package tests;

import com.codeborne.selenide.Configuration;

public class BaseTest {

    public static void setUpBrowser() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 4000;

    }

}
