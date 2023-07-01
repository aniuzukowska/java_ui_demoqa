package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EditRegistrationFormModal {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            submitButton = $("#submit");

    public EditRegistrationFormModal setNewFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }
}
