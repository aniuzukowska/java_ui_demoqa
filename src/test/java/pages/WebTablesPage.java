package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.EditRegistrationFormModal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WebTablesPage {
    EditRegistrationFormModal editRegistrationFormModal = new EditRegistrationFormModal();

    public WebTablesPage openPage() {
        step("Открываем страницу Elements/WebTables", () -> {
            open("/webtables");
        });
        return this;
    }

    public WebTablesPage editFirstName(String value1, String value2) {
        step("Исправляем FirstName "+value1, () -> {
            $(byText(value1)).parent().$(byAttribute("title", "Edit")).click();
            editRegistrationFormModal.setNewFirstName(value2).clickSubmit();
        });
        return this;
    }

    public void verifyResultEditedFirstName(String value) {
        $(byText(value)).shouldBe(visible);
    }

}
