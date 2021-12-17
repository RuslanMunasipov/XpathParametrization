package Hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class WebHooks {
    @BeforeAll
    public static void setDriverProps() {
        String webDriverLocation = Utils.Configuration.getConfigurationValue("webdriverLocalPath");
        if (webDriverLocation != null) {
            System.setProperty("webdriver.chromedriver", webDriverLocation);
            System.setProperty("selenide.browser", "Chrome");
            Configuration.startMaximized = true;
            Configuration.timeout = 120000;
        }
    }

    @AfterEach
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }

    @Before
    public static void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));
    }

    @BeforeEach
    public void startOpen(){
        open(Utils.Configuration.getConfigurationValue("url"));
    }
}
