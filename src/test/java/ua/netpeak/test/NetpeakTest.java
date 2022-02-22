package ua.netpeak.test;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ua.netpeak.data.RandomData.DATA;

public class NetpeakTest {

    @Test
    void test() {
        open("https://netpeak.ua/");
        $x("//ul[@class='menu-links']//a[.='Карьера']").click();
        switchTo().window(1);
        $x("//a[.='Я хочу работать в Netpeak']").scrollIntoView("{block: \"center\"}").click();
        $x("//input[@name='up_file']").uploadFile(new File("src/test/resources/netpeak_full_blue.png"));
        $x("//div[@id='up_file_name']/label[@class='control-label']")
                .shouldBe(visible)
                .shouldHave(exactText("Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf)."));
        $("#inputName").val(DATA.getName());
        $("#inputLastname").val(DATA.getLastName());
        $("#inputEmail").val(DATA.getEmail());
        $("#inputPhone").val(DATA.getPhone());
        $("[name='by']").selectOption(DATA.getIndexBY());
        $("[name='bm']").selectOption(DATA.getIndexBM());
        $("[name='bd']").selectOption(DATA.getIndexBD());
        $("#submit").click();
        $(".warning-fields")
                .shouldBe(visible)
                .shouldHave(exactText("Все поля являются обязательными для заполнения"));
        $x("//a[.='Интернатура']").click();
        webdriver().shouldHave(url("https://school.netpeak.group/"));
    }
}
