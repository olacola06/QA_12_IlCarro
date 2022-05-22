package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.regist().loggedIn()) {
            app.regist().logOut();
        }
    }

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String email = "user" + i + "@gmail.com"; //test fails with first UpperCase letter (User)
    String password = "Asd" + i + "d#%";

    @Test
    public void registrationPositive() {

        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Tom", "Morgan", email, password);
        logger.info("Registration with Email = " + email + ", and password = " + password);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        //app.regist().pause(5);

        Assert.assertTrue(app.regist().registrationSuccess());
        app.regist().clickOkBtn();

    }

    @Test
    public void registrationPositive2() {
        User user = new User().withName("Tom").withLastName("Morgan")
                .withEmail("user" + i + 1 + "@gmail.com").withPassword(password);
        logger.info("Registration with Email = " + user.email() + ", and password = " + user.password());

        app.regist().clickSignUp();
        app.regist().fillRegistrationFormFS(user);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationSuccess());
        app.regist().clickOkBtn();

    }
    @Test
    public void registrationNegativeMail() {
        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Ann", "Barry", "user" + i + "gmail.com", password);
        logger.info("Registration with Email = " + "user" + i + "gmail.com" + ", and password = " + password);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();
        app.regist().pause(3000);

        Assert.assertTrue(app.regist().registrationFailedMail());

    }

    @Test
    public void registrationNegativePass() {
        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Ann", "Barry", email, "asd" + i + "d#%");
        logger.info("Registration with Email = " + email + ", and password = " + "asd" + i + "d#%");
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();
        app.regist().pause(3000);

        Assert.assertTrue(app.regist().registrationFailedPass());

    }

    @Test
    public void registrationNegativeExist() {
        User user = new User().withName("Ann").withLastName("Barry")
                .withEmail("user2900@gmail.com").withPassword("Asd" + i + "d#%");
        logger.info("Registration with email = "+user.email()+ " and password = " +user.password());

        app.regist().clickSignUp();
        app.regist().fillRegistrationFormFS(user);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();

        Assert.assertTrue(app.regist().registrationFailedExist());
        app.regist().clickOkBtn();
    }
}