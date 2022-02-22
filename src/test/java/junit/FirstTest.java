package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successPracticeFormTest()  {
        open("/automation-practice-form");
        $x("//*[@id ='firstName']").setValue("Name");
        $x("//*[@id ='lastName']").setValue("Lastname");
        $x("//input[@placeholder='name@example.com']").setValue("name@mail.ru");
        $x("//*[text() = 'Other']").click();
        $x("//input[@placeholder='Mobile Number']").setValue("8999123121");
        $x("//*[@id ='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__month-select']").selectOption("June");
        $x("//*[@class='react-datepicker__year-select']").selectOption("1990");
        $x("//*[@class='react-datepicker__day react-datepicker__day--011']").click();
        $x("//*[@id ='subjectsInput']").setValue("Maths").pressEnter();
        $x("//*[text() = 'Music']").click();
        $x("//*[@id ='uploadPicture']").uploadFromClasspath("test.jpg");
        $x("//*[text() = 'Other']").click();
        $x("//*[@id ='currentAddress']").setValue("Москва");
        $x("//*[@id='state']").click();
        $x("//*[text() = 'NCR']").click();
        $x("//*[@id ='city']").click();
        $x("//*[text() ='Delhi']").click();
        $x("//*[text() = 'Submit']").click();
        $x("//*[@class ='modal-header']").shouldHave(text("Thanks for submitting the form"));
        $x("//*[@class='table-responsive']").shouldHave(text("Student Name Name Lastname"), text("Student Email name@mail.ru"),
                text("Gender Other"), text("Mobile 8999123121"), text("Date of Birth 11 June,1990"),
                text("Subjects Maths"), text("Hobbies Music"), text("Picture"),
                text("Address Москва"), text("State and City NCR Delhi"));
    }

}
