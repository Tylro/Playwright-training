package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

import page.TextboxPage;

public class TextboxTests {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;
    private TextboxPage textboxPage;
    private final String url = "https://demoqa.com/text-box";
    private final String fullname = "Tai";
    private final String email = "tai@mail.com";
    private final String currentaddr = "tma-lab4";
    private final String permanentaddr = "home";

    @BeforeSuite
    public void setUp() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url,
            new Page.NavigateOptions().setTimeout(60000).setWaitUntil(WaitUntilState.DOMCONTENTLOADED) );
        textboxPage = new TextboxPage(page);
    }

    @Test
    public void FillInTextBox() {

        textboxPage.enterFullName(fullname);
        textboxPage.enterEmail(email);
        textboxPage.enterCurrentAddress(currentaddr);
        textboxPage.enterPermanentAddress(permanentaddr);
        textboxPage.clickSubmit();
    }

    @Test 
    public void ValidateTextInput() {

        textboxPage.verifyName(fullname);
        textboxPage.verifyEmail(email);
        textboxPage.verifyCurrentAddr(currentaddr);
        textboxPage.verifyPermaAddr(permanentaddr);
        page.waitForTimeout(10000);
        page.evaluate(email);
    }

    @AfterSuite
    public void cleanUp() {
        
        browserContext.close();
        browser.close();
        playwright.close();
    }

}

