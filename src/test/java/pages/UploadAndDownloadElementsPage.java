package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class UploadAndDownloadElementsPage {
    public String pictureName = "picture.jpg";
    private final SelenideElement
            uploadFileElement = $("#uploadFile"),
            uploadedFilePath = $("#uploadedFilePath");
    public UploadAndDownloadElementsPage openPage() {
        step("Открываем страницу Upload and Download", () -> {
            open("/upload-download");
        });
        return this;
    }

    public UploadAndDownloadElementsPage uploadFile(String value) {
        step("Загружаем файл", () -> {
            uploadFileElement.uploadFromClasspath(value);
        });
        return this;
    }

    public void verifyResultUpload(String value) {
        uploadedFilePath.shouldHave(text(value));

    }

}
