package tests;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest extends BaseTest {


    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void moveAtoBWithActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions()
                .clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release()
                .perform();

        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void moveAtoBWithDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        $("#column-b").shouldHave(text("A"));
    }
}
