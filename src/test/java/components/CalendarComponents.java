package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponents {
    private final SelenideElement setYearDropdown = $(".react-datepicker__year-select");
    private final SelenideElement setMonthDropdown = $(".react-datepicker__month-select");
    private final ElementsCollection setDayInsideMonth = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {

        setYearDropdown.selectOptionContainingText(year);
        setMonthDropdown.selectOptionContainingText(month);
        setDayInsideMonth.findBy(text(day)).click();
    }

}
