package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingTest extends TestBase {

    @Test
    void checkOnboardingScreenTest() {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("The Free Encyclopedia"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("Data & Privacy"));
    }
}
