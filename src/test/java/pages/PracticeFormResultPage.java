package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormResultPage {

    public SelenideElement studentEmailResult = $x("//td[contains(text(),'Student Email')]/..//td[2]");
    public SelenideElement subjectsResult = $x("//td[contains(text(),'Subjects')]/..//td[2]");


}
