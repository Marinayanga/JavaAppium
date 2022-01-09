package lib.UI;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation() throws InterruptedException {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
            Thread.sleep(100);
        } else {
            System.out.println("Method openNavigation do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() throws InterruptedException {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(MY_LISTS_LINK,
                    "Cannot find navigation button to My List",
                    5);
            Thread.sleep(1000);
        } else {
            this.waitForElementAndClick(MY_LISTS_LINK,
                    "Cannot find navigation button to My List",
                    15);
        }
    }

}
