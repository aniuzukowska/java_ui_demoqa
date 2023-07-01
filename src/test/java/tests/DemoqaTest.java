package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.components.RegistrationResultsModal;
import utils.RandomStudent;

import static io.qameta.allure.Allure.step;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    CheckBoxElementsPage checkBoxElementsPage = new CheckBoxElementsPage();
    RadioButtonElementsPage radioButtonElementsPage = new RadioButtonElementsPage();
    TextBoxElementsPage textBoxElementsPage = new TextBoxElementsPage();
    ButtonsElementsPage buttonsElementsPage = new ButtonsElementsPage();
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
    @DisplayName("Выбор чек-бокса на странице Elements/CheckBox")
    void checkBoxElementsTest() {
        checkBoxElementsPage
                .openPage()
                .toggleClick(0)
                .setCheckBox("Desktop")
                .verifyResultForCheckBox("Desktop");
    }

    @Test
    @DisplayName("Выбор радио-кнопки на странице Elements/RadioButton")
    void radioButtonElementsTest() {
        radioButtonElementsPage
                .openPage()
                .setRadioButton("Yes")
                .verifyResultForRadioButton("Yes");
    }

    @Test
    @DisplayName("Заполнение полей ввода на странице Elements/TextBox")
    void textBoxElementsTest() {
        String
                userFullName = randomStudent.getRandomFullName(),
                userEmail = randomStudent.getRandomEmail(),
                userCurrentAddress = randomStudent.getRandomAddress(),
                userPermanentAddress = randomStudent.getRandomAddress();

        step("Заполняем форму TextBox", () -> {
            textBoxElementsPage
                    .openPage()
                    .setFullName(userFullName)
                    .setEmail(userEmail)
                    .setCurrentAddress(userCurrentAddress)
                    .setPermanentAddress(userPermanentAddress)
                    .clickSubmit()
                    .verifyResult("name", "Name:", userFullName)
                    .verifyResult("email", "Email:", userEmail)
                    .verifyResult("currentAddress", "Current Address :", userCurrentAddress)
                    .verifyResult("permanentAddress", "Permananet Address :", userPermanentAddress);
        });
    }

    @Test
    @DisplayName("Двойной клик по кнопке на странице Elements/Buttons")
    void doubleClickButtonElementsTest() {
        buttonsElementsPage
                .openPage()
                .doubleClickButton()
                .verifyDoubleClickResult("You have done a double click");
    }

    }


