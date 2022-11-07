package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JUnit5annotations {

    @BeforeAll
     static void beforeAll(){
        System.out.println("Start test scenario");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Test scenario finished");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Test case started");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test case passed");
    }

    @Test
    void successfulTest() throws InterruptedException {
        System.out.println("Test case 1");
        String studentFirstName = "Mikita";
        String studentLastName = "Anisimau";
        String studentEmail = "m.anisimau@godeltech.com";
        String studentPhoneNumber = "+48600231543";
        String dayOfBirth = "12";
        String monthOfBirth = "June";
        String yearOfBirth = "1997";
        String studentSubject = "Computer Science";
        String studentHobbies = "Music";
        String studentCurrentAddress = "Warszawa, Sriodmeisce 1";
        String studentState = "NCR";
        String studentCity = "Noida";


        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue(studentFirstName);
        $("[id=lastName]").setValue(studentLastName);
        $("[id=userEmail]").setValue(studentEmail);
        $("[for=gender-radio-1]").click();
        $("[id=userNumber]").setValue(studentPhoneNumber);

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day.react-datepicker__day--0" + dayOfBirth).click();
        $("[id=subjectsInput]").setValue(studentSubject);
        $("[id=subjectsInput]").pressEnter();
        $(byText(studentHobbies)).click();
        $("[id=uploadPicture]").uploadFile(new File("test.jp`g"));
        $("[id=currentAddress]").setValue(studentCurrentAddress);
        $("[id=state]").click();
        $(byText(studentState)).click();
        $("[id=city]").click();
        $(byText(studentCity)).click();





    }


}
