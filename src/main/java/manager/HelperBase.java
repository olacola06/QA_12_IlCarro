package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public void click(By locator) {
        wd.findElement(locator).click();

    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    public void clear(By locator) {
        wd.findElement(By.id("dates")).clear();
    }

    public void submitYalla() {
        click(By.cssSelector("form button[type='submit']"));
        //pause(3000);

    }

    public boolean loggedIn() {
        return wd.findElements(By.xpath("//*[text()=' Logout ']")).size() > 0;
    }

    public void clickOkBtn() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void logOut() {
        click(By.xpath("//*[text()=' Logout ']"));

    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void typeLocation(By locator, String location) {
        type(locator, location);
        pause(500);
        click(By.cssSelector("div.pac-item"));
        pause(1000);

    }

    public void waitWhile(By locator) {
        new WebDriverWait(wd, 5).until(ExpectedConditions.visibilityOf
                (wd.findElement(locator)));
    }

    public void returnMainPage() {
        click(By.xpath("//*[@alt='logo']"));
    }
}