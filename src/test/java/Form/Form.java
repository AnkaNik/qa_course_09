package Form;

import com.codeborne.selenide.Configuration;
import formFields.RandomValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Locale;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Form  extends RandomValue {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm() {
        // open form
        open("https://demoqa.com/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("[id='firstName']").val(firstName);
        $("[id='lastName']").val(lastName);
        $("[id='userEmail']").val(email);
        $("[id='userNumber']").val(phone);
        $("[id='currentAddress']").val(streetAddress);
        $("[id='genterWrapper']").$(byText(gender)).click();
        $("[id='hobbiesWrapper']").$(byText(hobby1)).click();
        $("[id='hobbiesWrapper']").$(byText(hobby3)).click();
        $("[id='subjectsInput']").val(subjectsInput).pressEnter();
        $("[id='uploadPicture']").uploadFile(new File("src/test/upload/picture.jpg"));

        $("[id='dateOfBirthInput']").click();
        $(".react-datepicker__year-select").selectOptionByValue("1978");
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__day.react-datepicker__day--013").click();


        $("[id='react-select-3-input']").setValue(state).pressEnter();
        $("[id='react-select-4-input']").setValue(city).pressEnter();


        $("#submit").click();

        // Check Submit
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(By.xpath("//*[@class='table-responsive']//tr[1]//td[2]")).shouldHave(text(firstName +" "+ lastName));
        $(By.xpath("//*[@class='table-responsive']//tr[2]//td[2]")).shouldHave(text(email));
        $(By.xpath("//*[@class='table-responsive']//tr[3]//td[2]")).shouldHave(text(gender));
        $(By.xpath("//*[@class='table-responsive']//tr[4]//td[2]")).shouldHave(text(phone));
        $(By.xpath("//*[@class='table-responsive']//tr[5]//td[2]")).shouldHave(text("13 April,1978"));
        $(By.xpath("//*[@class='table-responsive']//tr[6]//td[2]")).shouldHave(text(subjectsInput));
        $(By.xpath("//*[@class='table-responsive']//tr[7]//td[2]")).shouldHave(text(hobby1 + ", " + hobby3));
        $(By.xpath("//*[@class='table-responsive']//tr[8]//td[2]")).shouldHave(text("picture.jpg"));
        $(By.xpath("//*[@class='table-responsive']//tr[9]//td[2]")).shouldHave(text(streetAddress));
        $(By.xpath("//*[@class='table-responsive']//tr[10]//td[2]")).shouldHave(text(state + " " + city));
        $("[id='closeLargeModal']").click();


    }
}
