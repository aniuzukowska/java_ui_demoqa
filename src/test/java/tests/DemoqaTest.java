package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.components.RegistrationResultsModal;
import utils.RandomStudent;

import static io.qameta.allure.Allure.step;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    TrainingPage trainingPage = new TrainingPage();
    ElementsPage elementsPage = new ElementsPage();
    FormsPage formsPage = new FormsPage();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    RandomStudent randomStudent = new RandomStudent();

    @Test
    @DisplayName("Заполнение формы регистрации студента")
    void fillStudentRegistrationFormTest() {
        String
                userFirstName = randomStudent.getRandomFirstName(),
                userLastName = randomStudent.getRandomLastName(),
                userEmail = randomStudent.getRandomEmail(),
                userGender = randomStudent.getRandomGender(),
                userPhone = randomStudent.getRandomPhone(),
                userBirthDay = randomStudent.getRandomBirthDay("day"),
                userBirthMonth = randomStudent.getRandomBirthDay("month"),
                userBirthYear = randomStudent.getRandomBirthDay("year"),
                userSubject = randomStudent.getRandomSubject(),
                userHobby = randomStudent.getRandomHobby(),
                userAddress = randomStudent.getRandomAddress(),
                userState = randomStudent.getRandomState(),
                userCity = randomStudent.getRandomCity(userState);
        System.out.println(userBirthDay);

        step("Заполняем форму регистрации", () -> {
                    registrationPage.openPage()
                            .removeBanner()
                            .setFirstName(userFirstName)
                            .setLastName(userLastName)
                            .setEmail(userEmail)
                            .setGender(userGender)
                            .setPhone(userPhone)
                            .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                            .setSubject(userSubject)
                            .setHobby(userHobby)
                            .uploadFile(randomStudent.getFullName())
                            .setAddress(userAddress)
                            .setState(userState)
                            .setCity(userCity)
                            .clickSubmit();
                });

        step("Проверяем правильность заполнения формы", () -> {
            registrationResultsModal.verifyModalAppears()
                    .verifyResult("Student Name", userFirstName + " " + userLastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", userGender)
                    .verifyResult("Mobile", userPhone)
                    .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                    .verifyResult("Subjects", userSubject)
                    .verifyResult("Hobbies", userHobby)
                    .verifyResult("Address", userAddress)
                    .verifyResult("State and City", userState + " " + userCity)
                    .verifyResult("Picture", randomStudent.getFileName());
        });
    }

    @Test
    @DisplayName("Переход на главную страницу с формы регистрации студента")
    void goToMainPageFromStudentRegistrationFormTest() {
        registrationPage.openPage().clickMainTitle();
        mainPage.verifyResultOpenMainPage();

    }

    @Test
    @DisplayName("Переход на страницу с треннингами по клику на баннер на главной странице")
    void goToTrainingPageFromMainPageTest() {
        mainPage.openPage().clickBanner();
        trainingPage.verifyResultOpenTrainingPage();

    }

    @Test
    @DisplayName("Переход с главной страницы на страницу Elements")
    void goToElementsFromMainPageTest() {
        mainPage.openPage().cardElementsClick();
        elementsPage.verifyResultOpenElementsPage();
    }

    @Test
    @DisplayName("Переход с главной страницы на страницу Forms")
    void goToFormsFromMainPageTest() {
        mainPage.openPage().cardFormsClick();
        formsPage.verifyResultOpenFormsPage();
    }

}

