package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static tests.TestBase.app;

public class LetTheCarWork extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(!app.login().loggedIn()){
            app.login().clickLogin();
            app.login().fillLoginForm("user2900@gmail.com","As2900d#%");
            app.login().submitYalla();
        }
    }

    @Test(enabled = false)

    public void carSearchSuccess(){
        Car car = Car.builder().location("Haifa").make("Germany").model("BMW").year("2010").engine("1.6").fuel("").
                gear("").wD("").doors("4").seats("5").clasS("A").fuelConsumption("10").registrationNum("1546852").//should be unique//
                price("50").distance("500").features("Upgraded").about("Comfortable and reliable car").build();
        app.helperCar().clickLetTheCarWork();
        app.helperCar().fillForm(car);
        app.helperCar().addImage();
        app.helperCar().submit();

    }
}

