package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.login().loggedIn()) {
            app.login().logOut();
        }

    }
    @AfterMethod
    public void postCondition() {
        if (app.login().loginFail()){
            app.login().clickOkBtn();
            app.login().returnToMainPage();
        } else if (app.login().loginSuccess()) {
            app.login().clickOkBtn();
        }
    }
    @Test
    public void loginPositive() {
        app.login().clickLogin();
        app.login().fillLoginForm("user2900@gmail.com", "As2900d#%");
        app.login().submitYalla();

        Assert.assertTrue(app.login().loginSuccess());


    }
    @Test
    public void loginPositive2() {
        app.login().clickLogin();
        app.login().fillLoginForm("user29@gmail.com", "As2900d#%");
        app.login().submitYalla();

        Assert.assertTrue(app.login().loginSuccess());
    }

            @Test
        public void loginNegativeEmail() {
            app.login().clickLogin();
            app.login().fillLoginForm("user2900@gmailcom", "As2900d#%");
            app.login().submitYalla();

            //Assert.assertFalse(app.login().loginSuccess());
            Assert.assertTrue(app.login().loginFail());
        }
}
