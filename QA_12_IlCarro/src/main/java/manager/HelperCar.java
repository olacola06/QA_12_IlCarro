package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void clickLetTheCarWork() {
        click(By.cssSelector("a[href='/let-car-work']"));
    }

    public void fillForm(Car car) {
        typeLocation(By.id("pickUpPlace"), car.getLocation());
        type(By.cssSelector("input[id='make']"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());
        select(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getWD());
        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getRegistrationNum());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistance());
        type(By.cssSelector("input.feature-input"), car.getFeatures());
        type(By.id("about"), car.getAbout());

    }

        public void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);
//        new Select(wd.findElement(locator)).selectByIndex(1);
//        new Select(wd.findElement(locator)).selectByVisibleText(" Gas ");

    }

    public void addImage(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);

    }

    public void submitCar() {
        new WebDriverWait(wd, 10).until(ExpectedConditions.
                elementToBeClickable(wd.findElement(By.xpath("//*[text()='Submit']"))));
        click(By.xpath("//*[text()='Submit']"));
    }

    public boolean carAddedTrue() {
        String message = wd.findElement(By.xpath("//*[text()='Car added']")).getText();
        return message.contains("Car added");
    }
    public String carAddedEquels() {
        String message = wd.findElement(By.cssSelector("div h1.title")).getText();
        return message;
    }

    public void clickSearchCars() {
        click(By.xpath("//*[text()='Search cars']"));
    }

    public String wrongDataEntered() {
        String message = wd.findElement(By.cssSelector("div.error")).getText();
        return  message;
    }

    public boolean WrongDataMessageAppears() {
        if (wd.findElements(By.cssSelector("div.error")).size()<=0){
            return false;
        }
        return true;
    }
}


