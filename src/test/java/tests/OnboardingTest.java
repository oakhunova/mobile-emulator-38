package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OnboardingPage;

public class OnboardingTest extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();

    @Test
    @DisplayName("Проверка отображения текста на экранах онбординга")
    void checkOnboardingScreenTest() {
        onboardingPage.checkOnboardingScreenText("The Free Encyclopedia")
                .clickForwardButton()
                .checkOnboardingScreenText("New ways to explore")
                .clickForwardButton()
                .checkOnboardingScreenText("Reading lists with sync")
                .clickForwardButton()
                .checkOnboardingScreenText("Data & Privacy");
    }
}
