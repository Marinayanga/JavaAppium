package lib.UI.mobile_web;

import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {
        //ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeOther[contains(@name,'{TITLE}')]/../XCUIElementTypeOther[contains(@name,'{TITLE}')]";
        SAVED_ARTICLE_SCREEN = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";
        REMOVED_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'watched')]";
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'{TITLE}')]";
    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

