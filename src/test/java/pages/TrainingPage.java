package pages;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import com.codeborne.selenide.SelenideElement;


public class TrainingPage {
    private final SelenideElement
            title = $(".row .enroll__heading");


    public TrainingPage verifyResultOpenTrainingPage() {
        step("Проверяем, что выполнен переход на страницу с треннингами", () -> {
        title.shouldHave(text("Selenium Certification Training | Enroll Now | Study Online"));
        });
        return this;
        }
        }

