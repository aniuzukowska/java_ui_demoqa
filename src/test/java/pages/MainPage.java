package pages;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import com.codeborne.selenide.SelenideElement;


public class MainPage {
    private final SelenideElement
            banner = $(".banner-image"),
            cardElements = $(".category-cards").$(byText("Elements")),
            cardForms = $(".category-cards").$(byText("Forms"));

    public MainPage openPage() {
        step("Открываем главную страницу", () -> {
            open("/");
        });
        return this;
    }

    public MainPage clickBanner() {
        step("Кликаем по баннеру на главной странице", () -> {
            banner.click();
            switchTo().window(1);
        });
        return this;
    }

    public MainPage cardElementsClick() {
        step("Кликаем по карточке Elements", () -> {
            cardElements.scrollTo().click();
        });
        return this;
    }

    public MainPage cardFormsClick() {
        step("Кликаем по карточке Forms", () -> {
            cardForms.scrollTo().click();
        });
        return this;
    }

    public MainPage verifyResultOpenMainPage() {
        step("Проверяем, что выполнен переход на главную страницу", () -> {
            banner.shouldBe(visible);
        });
        return this;
    }
}
