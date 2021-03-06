package lib.UI;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private static final String
            LOGIN_BUTTON = "xpath://div/a[text()='Log in']",
            LOGIN_INPUT = "css:#wpName1",
            PASSWORD_INPUT = "css:input[name='wpPassword']",
            SUBMIT_BUTTON = "css:button[name='wploginattempt']";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("click Auth Button")
    public void clickAuthButton() throws InterruptedException {
        Thread.sleep(1000);
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot find auth button", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot click auth button", 5);
    }
    @Step("enter Login Data")
    public void enterLoginData(String login,String password){
        this.waitForElementAndSendKeys(LOGIN_INPUT,login,"Cannot find and put a login to the login input",5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT,password,"Cannot find and put a password to the password input",5);

    }

    @Step("submit Form")
    public void submitForm() throws InterruptedException {
        Thread.sleep(1000);
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit button",5 );
    }
}
