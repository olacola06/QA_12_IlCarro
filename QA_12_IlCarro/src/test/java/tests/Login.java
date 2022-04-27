package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeTest
    public void preCondition(){
        if (app.login().loggedIn()){
            app.login().logOut();
        }

    }

    @Test
    public void loginPositive() {
        app.login().clickLogin();
        app.login().fillLoginForm("user2900@gmail.com","As2900d#%");
        app.login().submitYalla();

        Assert.assertTrue(app.login().loginSuccess());

//        app.login().clickOkBtn();
//        app.login().chooseMostPopular();
//        app.login().chooseDates();

    }


}
