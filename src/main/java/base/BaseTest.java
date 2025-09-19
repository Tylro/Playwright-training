package base;

import java.io.ByteArrayInputStream;

import com.microsoft.playwright.Page;

import io.qameta.allure.Allure;

public class BaseTest {
    protected Page page;

    public BaseTest(Page page) {
        this.page = page;
    }
 
    public void click(String locator){
        page.locator(locator);
    }
 
    public void enterText(String locator, String value){
        page.locator(locator).fill(value);
    }
 
    public String getText(String locator){
        return page.locator(locator).innerText();
    }
 
    public boolean isVisiable(String locator){
        return page.locator(locator).isVisible();
    }
 
    public String getDynamicLocator(String locator, String value){
        return String.format(locator, value);
 
    }
 
    public void takeScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(
            page.screenshot(new Page.ScreenshotOptions().setFullPage(true))
        ));
    }
 
    public boolean verifyText(String actualText, String expectedText){
        return actualText.contains(expectedText);
    }
}
