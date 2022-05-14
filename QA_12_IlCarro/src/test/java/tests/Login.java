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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    @AfterMethod
    public void postCondition() {

        app.login().clickOkBtn();
    }
=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    @Test
    public void loginPositive() {
        app.login().clickLogin();
        app.login().fillLoginForm("user2900@gmail.com", "As2900d#%");
        app.login().submitYalla();


        Assert.assertTrue(app.login().loginSuccess());
        app.login().clickOkBtn();

    }
    @Test
    public void loginPositive2() {
        app.login().clickLogin();
        app.login().fillLoginForm("user29@gmail.com", "As2900d#%");
        app.login().submitYalla();

        Assert.assertTrue(app.login().loginSuccess());
        app.login().clickOkBtn();
    }

            @Test
        public void loginNegativeEmail() {
            app.login().clickLogin();
            app.login().fillLoginForm("user2900@gmailcom", "As2900d#%");
            app.login().submitYalla();
            app.login().pause(3000);

            //Assert.assertFalse(app.login().loginSuccess());
            Assert.assertTrue(app.login().loginFail());
                app.login().clickOkBtn();
        }
}
