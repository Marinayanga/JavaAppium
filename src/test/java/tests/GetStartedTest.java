package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.UI.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    @DisplayName("Test for skipped Welcome Page for iOS")
    @Description("skip welcome screen")
    @Severity(value = SeverityLevel.MINOR)
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
