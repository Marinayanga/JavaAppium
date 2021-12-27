/*
public class trash {


      private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds){
         WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
         wait.withMessage(error_message + "\n");
         By by = By.id(id);
         return wait.until(ExpectedConditions.presenceOfElementLocated(by));
     }
     private WebElement waitForElementByIdAndClick(String id, String error_message, long timeoutInSeconds){
         WebElement element =  waitForElementPresentById(id,error_message, 5);
         element.click();
         return element;
     }

    //WebElement element_to_init_search = driver.findElementByXPath();
    //element_to_init_search.click();
    //WebElement element_to_enter_search_line = waitForElementPresent("//*[contains(@text,'Search Wikipedia')]",
    //        "Cannot find the element");
    //        driver.findElementByXPath("//*[contains(@text,'Search…')]");
    //element_to_enter_search_line.sendKeys("Java");
}
*/


//public void testSaveTwoArticlesinOneFolder
 /*MainPageObject.waitForElementAndClick(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find the Wiki search page",
                5);
        MainPageObject.waitForElementAndSendKeys(By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find the element",
                5);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find the Java oop result",
                5);
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "cannot find article title",
                15);
        MainPageObject.waitForElementAndClick(By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5);
        MainPageObject.waitForElementPresent(By.xpath("//*[@text='Change language']"),
                "Cannot find Change language",
                5);

        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article options",
                5);
        MainPageObject.waitForElementAndClick(By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find button Got It",
                5);
        MainPageObject.waitForElementAndClear(By.id("org.wikipedia:id/text_input"),
                "Cannot find input to set list name",
                5);

        String name_of_folder = "Learning programming";
        MainPageObject.waitForElementAndSendKeys(By.id("org.wikipedia:id/text_input"),
                name_of_folder,
                "Cannot put text into list name input", 5);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='OK']"),
                "Cannot find button OK",
                5);
        MainPageObject.waitForElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article by X",
                5);
        MainPageObject.waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My List",
                5);
        MainPageObject.waitForElementAndClick(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My List",
                5);
        MainPageObject.waitForElementAndClick(By.xpath("//*[@text='" + name_of_folder + "']"),
                "Cannot find My reading List",
                5);
        MainPageObject.swipeElementToLeft(By.xpath("//*[@text='Java (programming language)']"),
                "cannot find saved articles",
                5);
        MainPageObject.waitForElementNotPresent(By.xpath("//*[@text='Java (programming language)']"),
                "cannot delete saved article",
                5);*/

