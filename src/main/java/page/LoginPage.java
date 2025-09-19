package page;

import com.microsoft.playwright.Page;

import base.BaseTest;

public class LoginPage extends BaseTest{
    private final String input = "//input[@name='%s']";
    private final String usernameName ="username";
    private final String passwordName ="password";
    private final String loginName = "submit";
    public LoginPage(Page page){
        super(page);
    }
 
    public void login(String username, String password){
        String dynamicUsername = getDynamicLocator(input, usernameName);
        String dynamicPassword = getDynamicLocator(input, passwordName);
        String dynamicLoginButton = getDynamicLocator(input, loginName);
 
        enterText(dynamicUsername, username);
        enterText(dynamicPassword, password);
        click(dynamicLoginButton);
        takeScreenshot("After clicking login");
 
    }
 
}
