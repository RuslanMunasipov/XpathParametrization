package PageSteps;

import PageElement.registrationElements;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class registrationSteps extends registrationElements {


    @Step("Заполнение поля {Имя}")
    public static void setName(String name) {
        uName.setValue(name);
    }

    @Step("Заполнения поля {Страна}")
    public static void setCountry(String country) {
        uCountry.setValue(country);
        $x(passPath).click();
        Selenide.switchTo().alert().accept();
        Selenide.switchTo().parentFrame();
    }


}
