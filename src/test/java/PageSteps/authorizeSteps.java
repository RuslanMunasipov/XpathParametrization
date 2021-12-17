package PageSteps;

import PageElement.authorizeElements;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class authorizeSteps extends authorizeElements {
    @Step("Проверка авторизации")
    public static void authorizeAssertion(String name, String country){
        authorizeAssert.shouldBe(visible);
        authorizeAssert.shouldHave(text(name));
        authorizeAssert.shouldHave(text(country));
    }
}
