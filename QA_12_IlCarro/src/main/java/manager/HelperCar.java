package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperCar extends HelperBase{

    public HelperCar (WebDriver wd){
        super(wd);
    }
    public void clickLetTheCarWork(){
        click(By.cssSelector("a[href='/let-car-work']"));
    }
    public void fillForm(Car car){
        typeLocation(By.id("pickUpPlace"), car.getLocation());
        type(By.cssSelector("input[id='make']"),car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"),car.getEngine());
        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWD());
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
    private void typeLocation(By locator, String location){
        type(locator,location);
        pause(500);
        click(By.cssSelector("div.pac-item"));
        pause(500);

    }
    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
//        new Select(wd.findElement(locator)).selectByIndex(1);
//        new Select(wd.findElement(locator)).selectByVisibleText(" Gas ");

    }
    public void addImage(String link){
        wd.findElement(By.id("photos")).sendKeys(link);

    }
    public void submit(){
        click(By.xpath("//*[text()='Submit']"));
    }

}
