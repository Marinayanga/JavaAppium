package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import lib.UI.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {
        //ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeOther[contains(@name,'{TITLE}')]/../XCUIElementTypeOther[contains(@name,'{TITLE}')]";
        SAVED_ARTICLE_SCREEN = "xpath://XCUIElementTypeNavigationBar[@name='Saved']";
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
    }

    public iOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
