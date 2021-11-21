package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    String dayOne = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    DayTwo dayTwo = new DayTwo();


    @Test
    void shouldBeTestForFirstHW() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Санкт-Петербург");
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(dayOne);
        $("[data-test-id='name'] input").setValue("Анисимова Виктория Эдуардовна");
        $("[data-test-id='phone'] input").setValue("+12345678901");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $$("button").find(exactText("Забронировать")).click();
        $(".notification_visible[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='notification']").shouldHave(text(dayOne));
    }

    @Test
    void shouldBeTestForSecondHW(){
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Са");
        $$(".menu-item").find(exactText("Самара")).click();
        $(".input__icon").click();
        if ($(byAttribute("data-day", dayTwo.getDayTwo())).isDisplayed() == false) {
            $("[data-step='1']").click();
        }
        $(byAttribute("data-day", dayTwo.getDayTwo())).click();
        $("[data-test-id='name'] input").setValue("Анисимова Виктория Эдуардовна");
        $("[data-test-id='phone'] input").setValue("+12345678901");
        $("[data-test-id='agreement'] .checkbox__box").click();
        $$("button").find(exactText("Забронировать")).click();
        $(".notification_visible[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id='notification']").shouldHave(text($("[data-test-id='date'] input").getAttribute("value")));
    }

}
