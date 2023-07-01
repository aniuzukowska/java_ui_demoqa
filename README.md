# Проект автоматизации тестирования UI для веб-приложения demoqa.com

<img width="1293" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/87ab626f-a758-4efa-a4f6-9c89e5e739d8">
<a href="https://demoqa.com">demoqa.com</a> - это тестовое веб-приложение, которое можно использовать для тренировки навыков тестирования.

## Содержание
+ [Тест-кейсы](#Тесты)
+ [Запуск автотестов из Jenkins](#Jenkins) 
+ [Оповещение о результатах через Telegram-бот](#Telegram) 
+ [Отчеты о прохождении тестов Allure report](#Allure) 
+ [Интеграция с Allure TestOPS](#TestOPS) 
+ [Интеграция с Jira](#Jira) 


<a name="Тесты">

## Тест-кейсы
  - Заполнение формы регистрации студента
  - Тесты навигации по приложению


<a name="Jenkins">

## Запуск автотестов из Jenkins
Для удаленного запуска автотестов в <a href="https://jenkins.autotests.cloud/job/Students/job/018-annazukowska-java-ui" target="_blank">Jenkins</a> создана задача (job), настроена и связана с репозиторием в GitHub.

<img width="1429" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/b95d4013-2d28-47db-afb8-8545b47716f4">



<a name="Telegram">

## Уведомление о результатах тестирования через Telegram-бот
После завершения тестов приходит такое оповещение в Telegram с помощью заранее созданного Telegram-бота, привязанного к задаче в Jenkins.

<img width="363" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/8ff7e507-1a45-4947-ba39-735badfe7cdf">

  

<a name="Allure">

## Отчеты о прохождении тестов Allure report
После завершения тестов также формируются отчеты <a href="https://jenkins.autotests.cloud/job/Students/job/018-annazukowska-java-ui/7/allure/" target="_blank">Allure report</a>, которые можно посмотреть со страницы задачи в Jenkins.

<img width="1430" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/5e5dee56-7ab0-4cc1-8ef0-1f6b5ec3cb76">
<img width="1435" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/a76c9725-4070-4ecd-8e8b-e924dcaa12c4">


  



<a name="TestOPS">

## Интеграция с Allure TestOPS
Настроена интеграция Jenkins с <a href="https://allure.autotests.cloud/project/3383/launches" target="_blank">Allure TestOPS</a>
При первом после интеграции прохождении тестов в Jenkins, в Allure TestOPS были автоматически созданы такие тест-кейсы:
<img width="1433" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/4c7757b6-6599-4a90-b202-70d6c9ac5e61">



<a name="Jira">

## Интеграция с Jira
Настроена интеграция Allure TestOPS с <a href="https://jira.autotests.cloud/browse/HOMEWORK-754" target="_blank">Jira</a>. К задаче в Jira привязаны тест-кейсы и прогон с результатами тестирования из Allure TestOPS.


<img width="1430" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/bf994acb-fd2e-430d-b11f-9e36e8ce23b9">
<img width="1431" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/f328c619-09f0-45b3-bf42-35782d2e3539">



