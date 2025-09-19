package tests;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SignupTests {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(500)
                .setArgs(Arrays.asList("--start-maximized"))
        );
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    public void SignupTest() {
        page.navigate("https://freelance-learn-automation.vercel.app/login");
        page.locator("xpath=//a[normalize-space()='New user? Signup']").click();
        Assert.assertTrue(page.locator("xpath=(//button[normalize-space()='Sign up'])").isDisabled());
        page.locator("xpath=(//input[@id='name'])[1]").fill("Tai");
        page.locator("xpath=(//input[@id='email'])[1]").fill("tai@gmai.com");
        page.locator("xpath=(//input[@id='password'])[1]").fill("1231234");
        page.getByLabel("Selenium").click();
        page.getByLabel("DemoPlay").click();
        page.locator("#gender2").click();
        // page.locator("#state").click();
        page.selectOption("#state", "Manipur");
        page.selectOption("#hobbies", "Swimming");
        System.out.println("The test is done");
    }


}
