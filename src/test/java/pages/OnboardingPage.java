package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage {
    private final SelenideElement onboardingScreenText = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Проверка текста")
    public OnboardingPage checkOnboardingScreenText(String text) {
            onboardingScreenText.shouldHave(text(text));
        return this;
    }

    @Step("Переключение на следюущий экран")
    public OnboardingPage clickForwardButton() {
        forwardButton.click();
        return this;
    }
}
