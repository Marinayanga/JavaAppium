package lib.UI.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.UI.NavigationUI;
import lib.UI.android.AndroidNavigationUI;
import lib.UI.ios.iOSNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        }else {
            return new iOSNavigationUI(driver);
        }
    }
}
