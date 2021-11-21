package ru.netology;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class DayTwo {
    private String dayTwo;

    public String getDayTwo() {
        LocalDateTime day1 = LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.of(15, 00, 00));
        day1.toEpochSecond(ZoneOffset.MAX);
        dayTwo = String.valueOf(day1.toEpochSecond(ZoneOffset.MAX) * 1000);
        return dayTwo;
    }


}
