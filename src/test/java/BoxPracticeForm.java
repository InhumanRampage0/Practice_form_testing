import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BoxPracticeForm {
    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
// usersData
        $("#firstName").setValue("Bogdan");
        $("#lastName").setValue("Pershko");
        $("#userEmail").setValue("Boduk99@mail.ru");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("0123456789");
// dataPicker
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--028").click();
// subjects
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Commerce").pressEnter();
// hobbies
        $(byText("Sports")).click();
        $(byText("Music")).click();
// selectPicture
        $("#uploadPicture").uploadFromClasspath("kumamon.jpg");
//putAddress
        $("#currentAddress").setValue("Sevastopol");
//selectStateAndCity
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Boduk99@mail.ru"),
             text("0123456789"), text("28 April,1992"), text("English, Hindi, Commerce"),
                text("Sports, Music"), text("Sevastopol"), text("NCR Noida"), text("kumamon.jpg"));



    }


}
// Посмотрел у ребята варианты проверок из таблицы.
// Возьму себе для исстории
//  $(".modal-header").shouldHave(text("Thanks for submitting the form"));
//        $(byText(firstName + " " + lastName)).shouldBe(visible);
//        $(byText(gender)).shouldBe(visible);
