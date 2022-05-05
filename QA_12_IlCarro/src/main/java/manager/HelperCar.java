package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperCar extends HelperBase{

    public HelperCar (WebDriver wd){
        super(wd);
    }
    public void clickLetTheCarWork(){
        click(By.cssSelector("a[href='/let-car-work']"));
    }
    public void fillForm(Car car){
        type(By.id("pickUpPlace"), car.getLocation());
        type(By.cssSelector("input[id='make']"),car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"),car.getEngine());
        type(By.id("fuel"),car.getFuel());
        type(By.id("gear"),car.getGear());
        type(By.id("wheelsDrive"),car.getWD());
        type(By.id("doors"),car.getDoors());
        type(By.id("seats"),car.getSeats());
        type(By.id("class"),car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"),car.getRegistrationNum());
        type(By.id("price"),car.getPrice());
        type(By.id("distance"),car.getDistance());
        type(By.cssSelector("input[class='feature-input']"),car.getFeatures());
        type(By.id("about"),car.getAbout());

    }
    public void addImage(){
        click(By.xpath("//*[text()='Add photos of your car']"));

    }
    public void submit(){
        click(By.xpath("//*[text()='Submit']"));
    }

}
