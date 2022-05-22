package tests;

import models.Car;
import org.testng.Assert;
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

    @Test(enabled = true)

    public void carSearchSuccess(){
        int i = (int)(System.currentTimeMillis())/1000%3600;

        Car car = Car.builder().location("Haifa").make("Germany").model("BMW").year("2010").engine("1.6").fuel("Gas").
                gear("AT").wD("AWD").doors("4").seats("5").clasS("A").fuelConsumption("10").registrationNum("123456"+i).//should be unique//
                price("50").distance("500").features("Upgraded").about("Comfortable and reliable car").build();

        app.helperCar().clickLetTheCarWork();
        app.helperCar().fillForm(car);
        app.helperCar().addImage("C:/Users/Olga/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        app.helperCar().submit();

       // Assert.assertTrue("");

    }
}

