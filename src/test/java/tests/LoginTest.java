package tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
 
import page.LoginPage;

@Test(description="Login Test Suite")
public class LoginTest {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;

    @BeforeSuite
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        
    }
    
    @Test(description="Login")
    public void Login(){
        page.navigate("https://access.tma.com.vn/cas/login");
        LoginPage loginpage = new LoginPage(page);
        loginpage.login("phtai1", "Phunhuan@8444");
        page.waitForTimeout(10000); // 2 seconds
        browserContext.close();
 
 
    }
 
}