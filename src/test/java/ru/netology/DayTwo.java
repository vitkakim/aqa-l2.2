package ru.netology;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;

public class DayTwo {
    private String dayTwo;
    private String day;
    private String month;
    private String today;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public String getDayTwo() throws ParseException {
        day = $(".calendar__day_state_today").getText();
        month = $(".calendar__name").getText();
        today = day + " " + month;
//        dayTwo = LocalDate.parse(today,
//                DateTimeFormatter.ofPattern("dd MMMM yyyy").localizedBy(Locale.forLanguageTag("ru"))).format(format);

        SimpleDateFormat formatIn = new SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("ru"));
        Date instance = formatIn.parse(today);
        LocalDate localDate = Instant.ofEpochMilli(instance.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
//        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("dd.MM.yyyy").format(instance) );
//        SimpleDateFormat formatOut = new SimpleDateFormat("dd.MM.yyyy");
        dayTwo = localDate.plusDays(7).format(format);
//        System.out.println(localDate);
        return dayTwo;
    }


}
