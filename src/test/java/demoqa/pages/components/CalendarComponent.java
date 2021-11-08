package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement calendarFormWrapper = $("#dateOfBirthInput");

    public void setDate(String year, String month) {
        calendarFormWrapper.click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--003").click();
    }
}
