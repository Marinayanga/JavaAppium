package lib.UI;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_CLEAR_BUTTON;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* Templates methods*/
    public static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* Templates methods*/

    @Step("Init search input")
    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find the Wiki search page", 5);
    }

    @Step("Wait for cancel button in input")
    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    @Step("Wait for cancel button in input dissapear")
    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    @Step("Cancel Search")
    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button and click", 5);
    }

    @Step("Type '{value}' in search input")
    public void typeSearchLine(String value) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, value, "Cannot find the element and type into search input", 5);
    }

    @Step("Wait for csearch results")
    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring, 5);
    }

    @Step("Click By Article With Substring")
    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }

    @Step("Get Amount Of Found Articles")
    public int getAmountOfFoundArticles() {

        this.waitForElementPresent(SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request ",
                15);
        return this.getAmountofElements(
                SEARCH_RESULT_ELEMENT);

    }

    @Step("Wait For Empty ResultLabel")
    public void waitForEmptyResultLabel() {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);

    }

    @Step("Assert There Is Not Result Of Search")
    public void assertThereIsNotResultOfSearch() {
        this.AssertElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We found some elements by requests ");
    }

    @Step("Assert Search Input Content")
    public void assertSearchInputContent(String search_input_text) {
        this.assertElementHasText(SEARCH_INIT_ELEMENT, search_input_text,
                "Texts in input are not similar", 5);
    }

    @Step("Take Fresh Search Screen")
    public void takeFreshSearchScreen() {
        this.waitForElementNotPresent(SEARCH_RESULT_ELEMENT, "list is not empty",
                5);
    }

    @Step("Clear Search Line")
    public void clearSearchLine() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(SEARCH_CLEAR_BUTTON,
                    "Cannot find search clear button",
                    10);
        } else {
            System.out.println("Method clearSearchLine does nothing for platform" + Platform.getInstance().getPlatformVar());

        }
    }


}
