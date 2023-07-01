package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.CheckBoxElementsData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckBoxElementsPage {
    CheckBoxElementsData checkBoxElementsData = new CheckBoxElementsData();
    private final ElementsCollection
            toggle = $$(".rct-collapse-btn"),
            checkBox = $$(".rct-title"),
            resultCheckedBoxes = $$(".text-success");
    private final SelenideElement resultTitle = $("#result");


    public CheckBoxElementsPage openPage() {
        step("Открываем страницу Elements/CheckBox", () -> {
            open("/checkbox");
        });
        return this;
    }

    public CheckBoxElementsPage toggleClick(Integer value) {
        toggle.get(value).click();
        return this;
    }

    public CheckBoxElementsPage setCheckBox(String value) {
        step("Выбираем чек-бокс " + value, () -> {
            checkBox.filterBy(text(value)).get(0).click();
        });
        return this;
    }

    public void verifyResultForCheckBox(String value) {
        step("Проверяем результат", () -> {
            resultTitle.$("span", 0).shouldHave(text("You have selected :"));
            String[] checkedBoxes = checkBoxElementsData.getCheckedBoxes(value);
            for(int i = 0; i < checkedBoxes.length; i++) {
                resultCheckedBoxes.get(i).shouldHave(text(checkedBoxes[i]));
            }
        });
    }
}
