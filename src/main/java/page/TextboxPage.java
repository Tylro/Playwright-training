package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
public class TextboxPage {

    private final Page page;
    private final Locator fullnameinput;
    private final Locator emailinput;
    private final Locator currentaddrinput;
    private final Locator permanentaddrinput;
    private final Locator submitbutton;
    private final Locator outputname;
    private final Locator outputemail;
    private final Locator outputcurrentaddr;
    private final Locator outputperaddr;

    public TextboxPage(Page page) {
        this.page = page;
        this.fullnameinput = page.locator("xpath=//input[@id='userName']");
        this.emailinput = page.locator("xpath=//input[@id='userEmail']");
        this.currentaddrinput = page.locator("xpath=//textarea[@id='currentAddress']");
        this.permanentaddrinput = page.locator("xpath=//textarea[@id='permanentAddress']");
        this.submitbutton = page.locator("xpath=//button[@id='submit']");
        this.outputname = page.locator("xpath=//p[@id='name']");
        this.outputemail = page.locator("xpath=//p[@id='email']");
        this.outputcurrentaddr = page.locator("xpath=//p[@id='currentAddress']");
        this.outputperaddr = page.locator("xpath=//p[@id='permanentAddress']");
    }

    public void enterFullName(String fullname) {
        fullnameinput.fill(fullname);
    }

    public void enterEmail(String email) {
        emailinput.fill(email);
    }

    public void enterCurrentAddress(String currentaddress) {
        currentaddrinput.fill(currentaddress);
    }

    public void enterPermanentAddress(String permanentaddress) {
        permanentaddrinput.fill(permanentaddress);
    }

    public void clickSubmit() {
        submitbutton.click();
    }

    public void verifyName(String expected) {
        PlaywrightAssertions.assertThat(outputname).containsText(expected);
    }

    public void verifyEmail(String expected) {
        PlaywrightAssertions.assertThat(outputemail).containsText(expected);
    }

    public void verifyCurrentAddr(String expected) {
        PlaywrightAssertions.assertThat(outputcurrentaddr).containsText(expected);
    }

    public void verifyPermaAddr(String expected) {
        PlaywrightAssertions.assertThat(outputperaddr).containsText(expected);
    }
}