# Проект автоматизации тестирования UI для веб-приложения demoqa.com

<img width="1293" alt="image" src="https://github.com/aniuzukowska/java_ui_demoqa/assets/109241600/87ab626f-a758-4efa-a4f6-9c89e5e739d8">
<a href="https://reqres.in" target="_blank">demoqa.com</a> - это тестовое веб-приложение.

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
Для удаленного запуска автотестов в <a href="https://jenkins.autotests.cloud/job/018-annazukowska-java-api/" target="_blank">Jenkins</a> создана задача (job), настроена и связана с репозиторием в GitHub.

<img width="1426" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/3725bb69-9058-4898-94d1-86e631600c92">


<a name="Telegram">

## Уведомление о результатах тестирования через Telegram-бот
После завершения тестов приходит такое оповещение в Telegram с помощью заранее созданного Telegram-бота, привязанного к задаче в Jenkins.

<img width="336" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/0d86d49f-7c6f-4bb4-9dc8-db664f3452c5">

  

<a name="Allure">

## Отчеты о прохождении тестов Allure report
После завершения тестов также формируются отчеты <a href="https://jenkins.autotests.cloud/job/018-annazukowska-java-api/2/allure/" target="_blank">Allure report</a>, которые можно посмотреть со страницы задачи в Jenkins.

<img width="1432" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/d926ba2d-f748-4f89-b63f-40bed739b99d">
<img width="1435" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/6c6d35fb-67c6-4020-8af6-a0e8b227bbb1">




<a name="TestOPS">

## Интеграция с Allure TestOPS
Настроена интеграция Jenkins с Allure TestOPS.
При первом после интеграции прохождении тестов в Jenkins, в Allure TestOPS были автоматически созданы такие тест-кейсы:
<img width="1433" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/76ac8b52-8463-4237-a9ab-90081faff91e">



<a name="Jira">

## Интеграция с Jira
Настроена интеграция Allure TestOPS с Jira. К задаче в Jira привязаны тест-кейсы и прогон с результатами тестирования из Allure TestOPS.

<img width="1260" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/6609cbba-4592-46f7-a81e-ddc489965eb0">
<img width="1257" alt="image" src="https://github.com/aniuzukowska/java_api_reqres/assets/109241600/9d0679e2-2591-49d9-bd34-97b5eb7236b2">


