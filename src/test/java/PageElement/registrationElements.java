package PageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class registrationElements extends BaseElements{
    public static final SelenideElement uName = $x("//input[@id = 'name']");
    public static final SelenideElement uCountry = $x("//input[@id = 'country']");
}
