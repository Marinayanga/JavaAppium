package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.ArticlePageObject;
import lib.UI.android.AndroidArticlePageObject;
import lib.UI.ios.iOSArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }else {
            return new iOSArticlePageObject(driver);
        }
    }
}
