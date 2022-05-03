package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class LetTheCarWork extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(!app.login().loginSuccess()){
            app.login().clickLogin();
            app.login().fillLoginForm("","");
            app.login().submitYalla();
        }
    }

    Car car = Car.builder().location("").make("").model("").year("").engine("").fuel("").
            gear("").wD("").doors("").seats("").clasS("").fuelConsumption("").registrationNum("").price("").distance("").
            features("").about("").build();



}

