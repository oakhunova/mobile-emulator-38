package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {
    private final SelenideElement searchFieldFromExploreTab = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchFieldInput = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection resultsContainer = $$(id("org.wikipedia.alpha:id/fragment_search_results"));
    private final SelenideElement searchTab = $(id("org.wikipedia.alpha:id/nav_tab_search"));
    private final SelenideElement searchFieldFromSearchTab = $(id("org.wikipedia.alpha:id/search_card"));

    @Step("Осуществление поиска из вкладки Explore")
    public SearchPage searchFromExploreTab(String word) {
        searchFieldFromExploreTab.click();
        searchFieldInput.sendKeys(word);
        return this;
    }

    @Step("Проверка найденных результатов поиска")
    public SearchPage checkResult() {
        resultsContainer.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Осуществление поиска из вкладки Search")
    public SearchPage searchFromSearchTab(String word) {
        searchTab.click();
        searchFieldFromSearchTab.click();
        searchFieldInput.sendKeys(word);
        return this;
    }

}
