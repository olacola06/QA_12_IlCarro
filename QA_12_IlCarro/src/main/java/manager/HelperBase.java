package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public void click(By locator){
        wd.findElement(locator).click();

    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    public void submitYalla(){
        click(By.cssSelector("form button[type='submit']"));
        //pause(3000);

    }

    public boolean loggedIn(){
        return wd.findElements(By.xpath("//*[text()=' Logout ']")).size()>0;
    }
    public void clickOkBtn() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void logOut(){
        click(By.xpath("//*[text()=' Logout ']"));

    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
