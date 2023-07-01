package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RadioButtonElementsPage {
    private final SelenideElement
        yesRadio = $(byAttribute("for","yesRadio")),
        impressiveRadio = $(byAttribute("for", "#impressiveRadio")),
        resultTitle = $(".mt-3"),
        resultRadioButton = $(".text-success");;
    ;

    public RadioButtonElementsPage openPage() {
        step("Открываем страницу Elements/RadioButton", () -> {
            open("/radio-button");
        });
        return this;
    }

    public RadioButtonElementsPage setRadioButton(String value) {
        step("Выбираем радио-кнопку " + value, () -> {
            if (Objects.equals(value, "Yes")) yesRadio.click();
            else if (Objects.equals(value, "Impressive")) impressiveRadio.click();
        });
        return this;
    }

    public void verifyResultForRadioButton(String value) {
        resultTitle.shouldHave(text("You have selected "));
        resultRadioButton.shouldHave(text(value));
    }
}
