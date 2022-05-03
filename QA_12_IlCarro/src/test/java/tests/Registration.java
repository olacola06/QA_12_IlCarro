package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String email = "user" + i + "@gmail.com"; //test fails with first UpperCase letter (User)
    String password = "Asd" + i + "d#%";

    @BeforeMethod
    public void preCondition() {
        if (app.regist().loggedIn()) {
            app.regist().logOut();
        }

    }

//    @AfterMethod
//    public void postCondition() {
//        if (app.regist().registrationSuccess()) {
//            app.regist().clickOkBtn();
//        }
//        else if (app.regist().registrationFailedExist()) {
//                app.regist().clickOkBtn();
//
//            }
//
//        }

    @Test
    public void registrationPositive() {

        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Tom", "Morgan", email, password);
        System.out.println("Email = " + email + ", and password = " + password);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationSuccess());
        app.regist().clickOkBtn();

    }

    @Test
    public void registrationPositive2() {

        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Tom", "Morgan", "user"+i+1+"@gmail.com", password);
        System.out.println("Email = " + email + ", and password = " + password);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationSuccess());
        app.regist().clickOkBtn();

    }

    @Test
    public void registrationNegativeMail() {
        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Ann", "Barry", "user" + i + "gmail.com", password);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationFailedMail());
    }

    @Test
    public void registrationNegativePass() {
        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Ann", "Barry", email, "asd" + i + "d#%");
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationFailedPass());
    }

    @Test
    public void registrationNegativeExist() {
        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Ann", "Barry", "user2900@gmail.com", "Asd" + i + "d#%");
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationFailedExist());
        app.regist().clickOkBtn();
    }
}