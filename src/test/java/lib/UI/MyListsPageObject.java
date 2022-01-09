package lib.UI;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String
            FOLDER_BY_NAME_TPL,
            SAVED_ARTICLE_SCREEN,
            REMOVED_FROM_SAVED_BUTTON,
            ARTICLE_BY_TITLE_TPL;

    private static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathTitle(String article_title) {
        return REMOVED_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle(String article_title) {
        return REMOVED_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("open Folder By Name")
    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(folder_name_xpath,
                "Cannot find folder by name" + name_of_folder,
                5);
    }

    @Step("wait For Article Apear By Title")
    public void waitForArticleApearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathTitle(article_title);
        this.waitForElementPresent(article_xpath,
                "Saved article is still not present with title " + article_title,
                10);
    }
    @Step("wait For Article Dissapear By Title")
    public void waitForArticleDissapearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathTitle(article_title);
        this.waitForElementNotPresent(article_xpath,
                "Saved article is still present with title " + article_title,
                5);
    }

    @Step("swipe By Article To Delete")
    public void swipeByArticleToDelete(String article_title) {
        this.waitForArticleApearByTitle(article_title);
        String article_xpath = getSavedArticleXpathTitle(article_title); //пересмотреть http://webinars-b.stqa.ru/mobile_automation_java/v1_430257/lesson4/06-testSaveFirstArticle.mp4 с 12 минуты

        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            this.swipeElementToLeft(article_xpath, "cannot find saved articles");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved",
                    10
            );
        }

        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        if (Platform.getInstance().isMW()) {
            driver.navigate().refresh();
        }
        this.waitForArticleDissapearByTitle(article_title);
    }

    @Step("wait For Saved Articles Screen")
    public void waitForSavedArticlesScreen() {
        this.waitForElementPresent(SAVED_ARTICLE_SCREEN, "Can not open saved article screen", 10);
    }


}
