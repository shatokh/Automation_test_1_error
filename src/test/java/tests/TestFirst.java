package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestFirst {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void happyTest(){
        String name = "Dima";

        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("dshatokh@gmail.com");
        $("[id=currentAddress]").setValue("Minsk 123");
        $("[id=permanentAddress]").setValue("Warsaw 123");

        $("[id=submit]").click();


        $("[id=output]").shouldHave(text(name), text("dshatokh@gmail.com"), text("Minsk 123"), text("Warsaw 123"));

        System.out.println("Happy Testing");

    }
}
