package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;

import lib.UI.ArticlePageObject;
import lib.UI.SearchPageObject;
import lib.UI.factories.ArticlePageObjectFactory;
import lib.UI.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Test for Search")
public class SearchTests extends CoreTestCase {

    @Test
    @Features(value={@Feature(value = "Search")})
    @DisplayName("Swipe article to footer")
    @Description("test search input")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearch() {


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
    }

    @Test
    @Features(value={@Feature(value = "Search")})
    @DisplayName("test Cancel Search")
    @Severity(value = SeverityLevel.NORMAL)
    public void testCancelSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();

        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }


    @Test
    @Features(value={@Feature(value = "Search")})
    @DisplayName("test Compare Search Title")
    @Severity(value = SeverityLevel.MINOR)
    public void testCompareSearchTitle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.assertSearchInputContent("Search Wikipedia");


    }

    @Test
    @Features(value={@Feature(value = "Search")})
    @DisplayName("test Search Few Articles")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSearchFewArticles() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.getAmountOfFoundArticles();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.takeFreshSearchScreen();

    }


    @Test
    @Features(value={@Feature(value = "Search")})
    @DisplayName("test Amount Of Non Empty Search")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testAmountOfNonEmptySearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_result = SearchPageObject.getAmountOfFoundArticles();
        Assert.assertTrue("We found too few results",
                amount_of_search_result > 0);
    }

    @Test
    @Features(value={@Feature(value = "Search")})
    @DisplayName("test Amount Of Empty Search")
    @Severity(value = SeverityLevel.MINOR)
    public void testAmountOfEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "dfsdfdsfdf";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNotResultOfSearch();


    }


   @Test
   @DisplayName("test for check right titles in search and in article")
   @Features(value={@Feature(value = "Search")})
    public void testForTitle() throws InterruptedException {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("bject-oriented programming language");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
       Assert.assertEquals("Wrong article was deleted",
               "Object-oriented programming language",
               article_title);


   }
}
