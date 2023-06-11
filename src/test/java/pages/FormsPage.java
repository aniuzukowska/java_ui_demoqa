package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class FormsPage {
    private final SelenideElement
            header = $(".main-header");

    public FormsPage verifyResultOpenFormsPage() {
        step("Проверяем, что выполнен переход на страницу Forms", () -> {
            header.shouldHave(text("Forms"));
        });
        return this;
    }
}
