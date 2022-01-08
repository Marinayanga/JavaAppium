package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.UI.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome(){

        if ((Platform.getInstance().isAndroid()) ||  (Platform.getInstance().isMW())){
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWaysToExplore();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddOrEditPreferredLanguages();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnedMoreAboutDataCollected();
        WelcomePage.clickGetStartedButton();





    }
}
