package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TextBoxElementsPage {
    private final SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxElementsPage openPage() {
        step("Открываем страницу TextBox", () -> {
            open("/text-box");
        });
        return this;
    }

    public TextBoxElementsPage setFullName(String value) {
        step("Вводим полное имя", () -> {
            fullNameInput.setValue(value);
        });
        return this;
    }

    public TextBoxElementsPage setEmail(String value) {
        step("Вводим email", () -> {
            emailInput.setValue(value);
        });
        return this;
    }

    public TextBoxElementsPage setCurrentAddress(String value) {
        step("Вводим текущий адрес", () -> {
            currentAddressInput.setValue(value);
        });
        return this;
    }

    public TextBoxElementsPage setPermanentAddress(String value) {
        step("Вводим постоянный адрес", () -> {
            permanentAddressInput.setValue(value);
        });
        return this;
    }

    public TextBoxElementsPage clickSubmit() {
        step("Нажимаем кнопку Submit", () -> {
            submitButton.click();
        });
        return this;
    }


    public TextBoxElementsPage verifyResult(String id, String key, String value) {
        step("Проверяем поле " + id, () -> {
            $("#output #"+id)
                    .shouldHave(text(key))
                    .shouldHave(text(value));
        });
        return this;
    }

}
