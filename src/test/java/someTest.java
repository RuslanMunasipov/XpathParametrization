import Hooks.WebHooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageSteps.BaseSteps.*;
import static PageSteps.authorizeSteps.authorizeAssertion;
import static PageSteps.registrationSteps.setCountry;
import static PageSteps.registrationSteps.setName;

public class someTest extends WebHooks {
    @Tag("1")
    @DisplayName("Авторизация тестового клиента")
    @Test
    public void authorizeV1() {
        setLogin(loginVal);
        setPass(passVal);
        clickToButton("Войти");
        authorizeAssertion("Тест", "Страна#");
    }

    @Tag("2")
    @DisplayName("Регистрация и авторизация клиента")
    @Test
    public void registrationV1(){
        clickToButton(versionVal="V2");
        clickToHrefButton("Зарегистрироваться");
        setUid("Test");
        setName("Somebody");
        setCountry("Уругвай");
        setPass("pass");
        clickToButton("Зарегестрироваться");
        setUid("Test");
        setPass("pass");
        clickToButton("Подключиться");
        authorizeAssertion("Somebody","Уругвай");
    }

    @Tag("3")
    @DisplayName("Регистрация клиента и авторизация по sessionId (в версиях V2 и V3)")
    @Test
    public void registrationV2(){
        clickToButton(versionVal="V2");
        clickToHrefButton("Зарегистрироваться");
        setUid("Tester");
        setName("User");
        setCountry("Уругвай");
        setPass("pass");
        getCheckBox("Создать идентификатор сессии автоматически", "true");
        getCheckBox("Создать идентификатор сессии автоматически", "false");
        generateSessionId();
        setSessionId("sid");
        clickToButton("Зарегестрироваться");
        getCheckBox("Войти по идентификатору","true");
        setSessionId("sid");
        clickToButton("Подключиться");
        authorizeAssertion("User","Уругвай");
    }

    @Tag("4")
    @DisplayName("Авторизация тестового клиента и повторный вход по созданному sessionId (в версиях V2 и V3)")
    @Test
    public void authorizeV2(){
        clickToButton(versionVal="V2");
        setLogin(loginVal);
        setPass(passVal);
        gettingSessionId();
        clickToButton("Подключиться");
        authorizeAssertion("Тест", "Страна#");
        clickToButton("Выйти из системы");
        getCheckBox("Войти по идентификатору", "true");
        settingSessionId("gotSid");
        clickToButton("Подключиться");
        authorizeAssertion("Тест", "Страна#");
    }
}
