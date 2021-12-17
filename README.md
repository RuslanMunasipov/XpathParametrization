1. #Тестовый проект направленный на изучение параметризации xpath.
2. #Выполнен на:
3. maven, junit, allure, maven, selenide.
4. #В файле sessionIdGenerator лежит не использованная реализация генератора случайного кода, может подойти для капчи.
5. #Если есть желание запустить тесты из класса SomeTest:
6. в тестах под тэгами 2,3 и 4 указать версионность в clickToButton(versionVal="V2"), где V2 - указание запускаемой версии.
7. #Команды для запуска из консоли: 
8. mvn clean test
9. mvn allure serve
10. #Версия
11. -Dversion=V*
12. Где * - номер версии.
13. #Номер теста
14. -Dgroups=*
15. Где * - указание тэга теста.
16. #Локальный запуск
17. Рассокментировать #webdriverLocalPath = /src/test/resources/WebDriver/chromedriver97.exe в props.properties