package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    String firstName = "Larysa";
    String lastName ="Shornikava";
    String email = "loryshornikova@gmail.com";
    String mobileNumber = "1111111111111";
    String currentAddress ="Homiel, Belarus";
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test

    void successfulSubmitForm() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('RightSide-Add').remove()");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $(new ByText("Female")).click();

        //$(("[for=\"gender-radio-2\"]")).click();

        $("[id=userNumber]").setValue(mobileNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select [value=\"1\"]").click();
        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__day--002").click();

        $("#subjectsInput").sendKeys("English");
        $ ("#subjectsInput").pressEnter();
        $("[for=\"hobbies-checkbox-2\"]").click();
        $("[for=\"hobbies-checkbox-3\"]").click();

        $("#uploadPicture").uploadFile(new File("src/test/java/Tests/sova.jpg"));

        $("#currentAddress").setValue(currentAddress);

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        //$(".modal-body").shouldHave(
        // text (firstName + " " + lastName),
        //text(email),
        //text("Female"),
        //text(mobileNumber),
        //text("02 February,1984"),
        //text("English"),
        //text("Reading, Music"),
        //text(currentAddress),
        //text("NCR Delhi")
        //);


        System.out.println("Successful test");

    }
}
