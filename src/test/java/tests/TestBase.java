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

    private static String mode;

    @BeforeAll
    static void setupSelenideConfig() {
        mode = System.getProperty("mode", "emulator");
        System.setProperty("mode", mode);
        Configuration.browser = chooseDriver(mode).getClass().getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Selenide.open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = null;

        try {
            if (Selenide.sessionId() != null) {
                sessionId = Selenide.sessionId().toString();
                System.out.println("Session ID: " + sessionId);
            } else {
                System.out.println("Warning: Session ID is null");
            }
        } catch (Exception e) {
            System.out.println("Warning: Failed to get session ID: " + e.getMessage());
        }

        try {
            Attach.pageSource();
        } catch (Exception e) {
            System.out.println("Warning: Failed to attach page source: " + e.getMessage());
        }

        Selenide.closeWebDriver();

        if ("browserstack".equals(mode) && sessionId != null && !sessionId.isEmpty()) {
            try {
                System.out.println("Adding video attachment for BrowserStack session...");
                Attach.addVideo(sessionId);
            } catch (Exception e) {
                System.out.println("Warning: Failed to add video attachment: " + e.getMessage());
                e.printStackTrace();
            }
        } else if ("emulator".equals(mode)) {
            System.out.println("Skipping video attachment for emulator mode");
        }
    }

    static WebDriverProvider chooseDriver(String mode) {
        return switch (mode) {
            case "browserstack" -> new BrowserstackDriver();
            case "emulator" -> new EmulatorDriver();
            default -> throw new IllegalArgumentException("Unknown mode: " + mode);
        };
    }
}