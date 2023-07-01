package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ButtonsElementsPage {
    private  final SelenideElement
            doubleClickBtn = $("#doubleClickBtn"),
            resulDoubleClick = $("#doubleClickMessage");

    public ButtonsElementsPage openPage() {
        step("Открываем страницу Elements/Buttons", () -> {
            open("/buttons");
        });
        return this;
    }

    public ButtonsElementsPage doubleClickButton() {
        step("Кликаем дважды по кнопке", () -> {
            doubleClickBtn.doubleClick();
        });
        return this;
    }

    public void verifyDoubleClickResult(String value) {
        resulDoubleClick.shouldHave(text(value));
    }

}
