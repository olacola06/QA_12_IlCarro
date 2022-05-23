package tests;

import models.User;
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
    @AfterMethod(enabled = true)
    public void postCondition() {
        app.login().clickOkBtn();
    }

    @Test
    public void loginPositive() {
        app.login().clickLogin();
        app.login().fillLoginForm("user2900@gmail.com", "As2900d#%");
        logger.info("Login with email:---> user2900@gmail.com and password:---> As2900d#%");
        app.login().submitYalla();
        app.login().pause(1000);

        Assert.assertTrue(app.login().loginSuccess());

    }
    @Test
    public void loginPositive2() {
        app.login().clickLogin();
        app.login().fillLoginFormFS(new User().withEmail("user2900@gmail.com").withPassword("As2900d#%"));
        logger.info("Login with email:---> user2900@gmail.com and password:---> As2900d#%");
        app.login().submitYalla();
        app.login().waitWhile(By.xpath("//*[@class='dialog-container']"));

        Assert.assertTrue(app.login().loginSuccess());

    }
    @Test
        public void loginNegativeEmail() {
            app.login().clickLogin();
            app.login().fillLoginForm("user2900@gmailcom", "As2900d#%");
            logger.info("Login with email:---> user2900@gmailcom and password:---> As2900d#%");
            app.login().submitYalla();
            app.login().pause(3000);

            //Assert.assertFalse(app.login().loginSuccess());
            Assert.assertTrue(app.login().loginFail());

        }
}
