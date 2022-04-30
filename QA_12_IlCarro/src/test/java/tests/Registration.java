package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if (app.regist().loggedIn()){
            app.regist().logOut();
        }

    }

    int i = (int) (System.currentTimeMillis()/1000)%3600;
    String email = "user"+i+"@gmail.com"; //test fails with first UpperCase letter (User)
    String password = "Asd"+i+"d#%";


    @Test
    public void registrationPositive() {

        app.regist().clickSignUp();
        app.regist().fillRegistrationForm("Tom","Morgan",email,password);
        System.out.println("Email = "+email+", and password = "+password);
        app.regist().markCheckBoxXY();
        app.regist().submitYalla();
        System.out.println("Email = "+email+"password = "+password);

        Assert.assertTrue(app.regist().registrationSuccess());
    }
}
