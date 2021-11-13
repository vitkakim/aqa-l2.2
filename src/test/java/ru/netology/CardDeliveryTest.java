package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");


    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Санкт-Петербург");
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        $("[data-test-id='date'] input").setValue(format.format(calendar.getTime()));
        $("[data-test-id='name'] input").setValue("Анисимова Виктория Эдуардовна");
        $("[data-test-id='phone'] input").setValue("+12345678901");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $$("button").find(exactText("Забронировать")).click();
        $(".notification_visible[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        String actualMessage = $("[data-test-id='notification'] .notification__content").getText().strip();
        String expectedMessage = "Встреча успешно забронирована на " + format.format(calendar.getTime());
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
