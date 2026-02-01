package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("Проверка поиска из вкладки Explore")
    void exploreTabSearchTest() {
        step("Закрыть экран онбординга", () -> back());
        step("Осуществить поиск", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверка, что результаты найдены", () ->
                $$(id("org.wikipedia.alpha:id/fragment_search_results"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка поиска из вкладки Search")
    void searchTabSearchTest() {
        step("Закрыть экран онбординга", () -> back());
        step("Перейти на вкладку Search и осуществить поиск", () -> {
            $(id("org.wikipedia.alpha:id/nav_tab_search")).click();
            $(id("org.wikipedia.alpha:id/search_card")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Skateboard");
        });
        step("Проверка, что результаты найдены", () ->
                $$(id("org.wikipedia.alpha:id/fragment_search_results"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
