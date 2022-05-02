package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperRegistration extends HelperBase {

    public HelperRegistration(WebDriver wd) {
        super(wd);
    }

    public void clickSignUp() {
        click(By.xpath("//*[text()=' Sign up ']"));

    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.xpath("//*[@id='name']"), name);
        type(By.xpath("//*[@id='lastName']"), lastName);
        type(By.cssSelector("div input#email"), email);
        type(By.cssSelector("div input#password"), password);
    }

    public void markCheckBox() {
        //click(By.xpath("//*[@id='terms-of-use']"));//Selenium doesn't see it
        //click(By.xpath("//*[@class='checkbox-label terms-label']"));
        click(By.css(label[for='terms-of-use']);

    }

    public boolean registrationSuccess(){
        System.out.println(wd.findElement(By.xpath("//*[@id='mat-dialog-0']")).getText());
        String message = wd.findElement(By.xpath("//*[@id='mat-dialog-0']")).getText();
        return message.contains("Registered") & (wd.findElements(By.xpath("//*[text()='Ok']")).size()>0);
    }
}
