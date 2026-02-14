package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import static com.codeborne.selenide.Selenide.back;

public class SearchTests extends TestBase {

    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("Проверка поиска из вкладки Explore")
    void exploreTabSearchTest() {
        back();
        searchPage.searchFromExploreTab("Appium")
                .checkResult();
    }

    @Test
    @DisplayName("Проверка поиска из вкладки Search")
    void searchTabSearchTest() {
        back();
        searchPage.searchFromSearchTab("Skateboard")
                .checkResult();
    }
}