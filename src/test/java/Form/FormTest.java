package Form;

import com.codeborne.selenide.Configuration;
import formFields.StudentData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest extends StudentData {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        // open form
        open("https://demoqa.com/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#userNumber").val(phone);
        $("#currentAddress").val(streetAddress);
        $("#genterWrapper").$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        $("#subjectsInput").val(subjectsInput).pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/upload/picture.jpg"));
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1978");
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__day.react-datepicker__day--013").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        // Check Submit
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//*[@class='table-responsive']//tr[1]//td[2]").shouldHave(text(firstName +" "+ lastName));
        $x("//*[@class='table-responsive']//tr[2]//td[2]").shouldHave(text(email));
        $x("//*[@class='table-responsive']//tr[3]//td[2]").shouldHave(text(gender));
        $x("//*[@class='table-responsive']//tr[4]//td[2]").shouldHave(text(phone));
        $x("//*[@class='table-responsive']//tr[5]//td[2]").shouldHave(text("13 April,1978"));
        $x("//*[@class='table-responsive']//tr[6]//td[2]").shouldHave(text(subjectsInput));
        $x("//*[@class='table-responsive']//tr[7]//td[2]").shouldHave(text(hobby1 + ", " + hobby3));
        $x("//*[@class='table-responsive']//tr[8]//td[2]").shouldHave(text("picture.jpg"));
        $x("//*[@class='table-responsive']//tr[9]//td[2]").shouldHave(text(streetAddress));
        $x("//*[@class='table-responsive']//tr[10]//td[2]").shouldHave(text(state + " " + city));
        $("#closeLargeModal").click();
    }
}
