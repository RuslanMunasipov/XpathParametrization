package PageSteps;

import PageElement.BaseElements;
import Stash.Stash;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.UUID;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BaseSteps extends BaseElements {
    public static SelenideElement sidElement;

    @Step("Заполнение графы {Идентификатор пользователя}")
    public static void setUid(String name) {
        $x(loginPath).setValue(name);
    }

    @Step("Ввести логин")
    public static void setLogin(String name) {
        $x(loginPath).setValue(name);
    }

    @Step("Ввести пароль")
    public static void setPass(String name) {
        $x(passPath).setValue(name);
    }

    @Step("Нажать на кнопку в зависимости от ее имени")
    public static SelenideElement clickToButton(String name) {
        getButton(name).shouldBe(visible, Duration.ofSeconds(10)).click();
        return getButton(name);
    }

    @Step("Нажать на ссылочную кнопку в зависимости от ее имени")
    public static SelenideElement clickToHrefButton(String name) {
        getHrefButton(name).shouldBe(visible, Duration.ofSeconds(10)).click();
        return getHrefButton(name);
    }

    @Step("Проверка чекбокса")
    public static SelenideElement getCheckBox(String name, String condition) {
        SelenideElement checkBox = $x("//label[./span[text()='" + name + "']]//input");
        if (condition.equals("false")) {
            if (checkBox.$x("./../..").getAttribute("class").contains("Mui-checked")) {
                checkBox.click();
            }
        } else {
            if (!checkBox.$x("./../..").getAttribute("class").contains("Mui-checked")) {
                checkBox.click();
            }
        }
        return checkBox;
    }

    @Step("Генерируем Session ID и сохраняем в sessionId")
    public static void generateSessionId() {
        String sid = UUID.randomUUID().toString();
        Stash.put("sid", sid);
    }

    @Step("Заполняем SessionId")
    public static void setSessionId(String sid){
        $x("//input[@name = 'sessionId']").setValue(Stash.get(sid).toString());
    }

    @Step("Забираем SessionId из строки")
    public static void gettingSessionId(){
       sidElement = $x("//input[@name = 'sessionId']");
       String gotSid = sidElement.getValue();
       Stash.put("gotSid", gotSid);
    }

    @Step("Заполняем SessionId взятый из строки")
    public static void settingSessionId(String gotSid){
        sidElement.setValue(Stash.get(gotSid).toString());
    }
}

