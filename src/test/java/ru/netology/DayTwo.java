package ru.netology;

import static com.codeborne.selenide.Selenide.$$;

public class DayTwo {
    private String dayTwo;
    private int dayInMS = 86400000;

    public String getDayTwo() {
        String dayPlus = $$("[data-day]").first().getAttribute("data-day");
        dayTwo = String.valueOf(Long.valueOf(dayPlus) + dayInMS * 4);

        return dayTwo;
    }


}
