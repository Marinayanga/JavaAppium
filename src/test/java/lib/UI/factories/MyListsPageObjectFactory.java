package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.MyListsPageObject;
import lib.UI.NavigationUI;
import lib.UI.android.AndroidMyListsPageObject;
import lib.UI.android.AndroidNavigationUI;
import lib.UI.ios.iOSMyListsPageObject;
import lib.UI.ios.iOSNavigationUI;
import lib.UI.mobile_web.MWArticlePageObject;
import lib.UI.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory {

    public static MyListsPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else if (Platform.getInstance().isIOS()) {
            return new iOSMyListsPageObject(driver);
        } else {
            return new MWMyListsPageObject(driver);
        }
    }
}
