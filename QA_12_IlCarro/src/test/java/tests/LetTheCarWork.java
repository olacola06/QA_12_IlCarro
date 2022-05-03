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
            app.login().fillLoginForm("user2900@gmail.com","As2900d#%");
            app.login().submitYalla();
        }
    }

    Car car = Car.builder().location("Haifa").make("GErmany").model("BMW").year("2010").engine("1.6").fuel("").
            gear("").wD("").doors("4").seats("5").clasS("A").fuelConsumption("10").registrationNum("1546852").
            price("50").distance("500").features("").about("").build();



}

