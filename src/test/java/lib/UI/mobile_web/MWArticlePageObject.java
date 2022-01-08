package lib.UI.mobile_web;

import lib.UI.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:minerva-footer";
        OPTION_ADD_TO_MY_LIST_BUTTON = "xpath://a[contains( text(),'Watch')]";
        OPTION_REMOVE_FROM_MY_LIST_BUTTON="xpath://a[contains( text(),'Unwatch')]";

    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}