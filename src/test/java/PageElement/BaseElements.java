package PageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseElements {

    public static String loginVal = Utils.Configuration.getConfigurationValue("login");
    public static String passVal = Utils.Configuration.getConfigurationValue("password");
    public static String versionVal = Utils.Configuration.getConfigurationValue("version");

    public static final String loginPath = "//input[@id = 'uid']";
    public static final String passPath = "//input[@id = 'password']";
    public static final SelenideElement authorizeAssert = $x("//h2");

    //  Кнопка переключения версий и входа
    public static SelenideElement getButton(String name) {
        SelenideElement uniButton = $x("//*[@class='MuiButton-label' and text() = '" + name + "']");
        return uniButton;
    }

    //  Кнопка ссылочного типа (восстановить доступ и зарегистрироваться)
    public static SelenideElement getHrefButton(String name) {
        SelenideElement hrefButton = $x("//*[@href = '#' and text() = '" + name + "']");
        return hrefButton;
    }
}
