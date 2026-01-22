package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    @BeforeAll
    static void setupSelenideConfig() {
        String mode = System.getProperty("mode", "emulator");
        System.setProperty("mode", mode);
        Configuration.browser = chooseDriver(mode).getClass().getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println("Session ID: " + sessionId);

        Attach.pageSource();
        Selenide.closeWebDriver();
        Attach.addVideo(sessionId);
    }


        static WebDriverProvider chooseDriver(String mode) {
        return switch (mode) {
            case "browserstack" -> new BrowserstackDriver();
            case "emulator" -> new EmulatorDriver();
            default -> throw new IllegalArgumentException("Unknown mode: " + mode);
        };
    }
}