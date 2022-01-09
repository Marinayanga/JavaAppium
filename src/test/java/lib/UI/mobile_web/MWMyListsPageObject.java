package lib.UI.mobile_web;

import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    static {

        REMOVED_FROM_SAVED_BUTTON = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class,'watched')]";
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class, 'watchlist')]//h3[contains(text(), '{TITLE}')]";

    }

    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

