package tests;

import manager.MyDataProvider;
import models.Car;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LetTheCarWork extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void preCondition() {
        if (!app.login().loggedIn()) {
            app.login().clickLogin();
            app.login().fillLoginForm("user2900@gmail.com", "As2900d#%");
            app.login().submitYalla();
        }
    }

    @Test(groups = {"allPositive"}, enabled = true, dataProvider = "letTheCarWorkDataLombok", dataProviderClass = MyDataProvider.class)

    public void carSearchSuccess(Car car) {
//    Car car = Car.builder().location("Haifa").make("Germany").model("BMW").year("2010").engine("1.6").fuel("Gas").
//                gear("AT").wD("AWD").doors("4").seats("5").clasS("A").fuelConsumption("10").registrationNum("123456"+i).//should be unique//
//                price("50").distance("500").features("Upgraded").about("Comfortable and reliable car").build();
        logger.info("Test starts with car details:--->" + car.getLocation() + ", " + car.getModel() + ", " + car.getMake());

        app.helperCar().clickLetTheCarWork();
        app.helperCar().fillForm(car);
        app.helperCar().addImage("C:/Users/Olga/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        //app.helperCar().addImage("C:/Users/Olga/GitHub/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        app.helperCar().submitCar();

        Assert.assertTrue(app.helperCar().carAddedTrue());
        logger.info("Test finished, added car-->" + car.toString());
        app.helperCar().clickSearchCars();

    }

    //@Test(groups = {"allPositive"}, dataProvider = "letTheCarWorkValidData",dataProviderClass = MyDataProvider.class)
    @Test(groups = {"allPositive"}, dataProvider = "letTheCarWorkValidWithoutSingapore", dataProviderClass = MyDataProvider.class)
    public void carSearchSuccessDP(Car car) {
        int i = (int) (System.currentTimeMillis()) / 1000 % 3600;
        car.setRegistrationNum("10-15-13" + i);
        logger.info("Test starts with car details-->" + car.toString());

        app.helperCar().clickLetTheCarWork();
        app.helperCar().fillForm(car);

        //app.helperCar().addImage("C:/Users/Olga/GitHub/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        app.helperCar().addImage("C:/Users/Olga/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        app.helperCar().submitCar();

        Assert.assertTrue(app.helperCar().carAddedTrue());
        logger.info("Test finished, car added Success");
        app.helperCar().clickSearchCars();

    }

    @Test(dataProvider = "letTheCarWorkWrongData", dataProviderClass = MyDataProvider.class)
    public void carSearchFail(Car car) {
//        Car car = Car.builder().location("Tokio, Japan").make("Japan").model("Toyota").year("2010").engine("2.6").fuel("Petrol").
//                gear("MT").wD("FWD").doors("3").seats("5").clasS("SuperClass").fuelConsumption("10").registrationNum("100-20-300").
//                price("-1").distance("120").features("Like new one").about("Amazing car").build();

        int i = (int) (System.currentTimeMillis()) / 1000 % 3600;
        car.setRegistrationNum(car.getRegistrationNum() + i);
        //car.setRegistrationNum("10-15-133"+i);

        logger.info("Car to be added-->" + car.toString());

        app.helperCar().clickLetTheCarWork();
        app.helperCar().fillForm(car);
        app.helperCar().addImage("C:/Users/Olga/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        //app.helperCar().addImage("C:/Users/Olga/GitHub/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        logger.info("Car was not added, entered wrong data-->" + app.helperCar().wrongDataEntered());

        Assert.assertTrue(app.helperCar().WrongDataMessageAppears());
        app.helperCar().returnMainPage();

    }

    @Test(enabled = true, groups = {"problemSingapore"},dataProvider = "carSearchSingaporeLocations",dataProviderClass = MyDataProvider.class)
    public void carSearchSingaporeOnly(Car car) {

        logger.info("Car to be added-->" + car.toString());

        app.helperCar().clickLetTheCarWork();
        app.helperCar().fillForm(car);
        app.helperCar().addImage("C:/Users/Olga/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        //app.helperCar().addImage("C:/Users/Olga/GitHub/QA_12_IlCarro/QA_12_IlCarro/auto2.jpeg");
        app.helperCar().submitCar();

        app.helperCar().whichElementAppears();

    }
}



