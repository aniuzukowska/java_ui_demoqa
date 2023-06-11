package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ElementsPage {
    private final SelenideElement
            header = $(".main-header");

    public ElementsPage verifyResultOpenElementsPage() {
        step("Проверяем, что выполнен переход на страницу Elements", () -> {
            header.shouldHave(text("Elements"));
        });
        return this;
    }
}
