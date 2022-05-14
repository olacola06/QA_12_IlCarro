package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void fillRegistrationFormFS(User user) {
        type(By.xpath("//*[@id='name']"), user.name());
        type(By.xpath("//*[@id='lastName']"), user.lastName());
        type(By.cssSelector("div input#email"), user.email());
        type(By.cssSelector("div input#password"), user.password());
    }

//    public void markCheckBox() {
//        //click(By.xpath("//*[@id='terms-of-use']"));//Selenium doesn't see it
//        //click(By.xpath("//*[@class='checkbox-label terms-label']"));
//        click(By.css(label[for='terms-of-use']);

    public void markCheckBoxXY() {
<<<<<<< Updated upstream
       WebElement checkBox = wd.findElement(By.id("terms-of-use"));

        if (!checkBox.isSelected()) {

            WebElement label = wd.findElement(By.xpath("//*[@class='checkbox-label terms-label']"));
            Rectangle rect = label.getRect();
            int XOffset = rect.getWidth() / 2;
            int YOffset = 0;

=======

        WebElement checkBox = wd.findElement(By.cssSelector("div input[type='checkbox']"));
        if(!checkBox.isSelected()) {
            WebElement label = wd.findElement(By.xpath("//*[@class='checkbox-label terms-label']"));
            Rectangle rect = label.getRect();
            int XOffset = rect.getWidth() / 2;
            int YOffset = 0;

>>>>>>> Stashed changes
            Actions actions = new Actions(wd);
            actions.moveToElement(label).moveByOffset(-XOffset, YOffset).click().release().perform();
        }

    }

    public boolean registrationSuccess(){
        new WebDriverWait(wd,5).until(ExpectedConditions.
                visibilityOf(wd.findElement(By.xpath("//*[@class='cdk-overlay-pane']"))));
        System.out.println(wd.findElement(By.xpath("//*[@class='cdk-overlay-pane']")).getText());
        String message = wd.findElement(By.xpath("//*[@class='cdk-overlay-pane']")).getText();
        return message.contains("Registered");
    }

    public boolean registrationFailedMail(){
        String message = wd.findElement(By.xpath("//*[text()='Wrong email format']")).getText();
        return message.contains("Wrong email format");

    }
    public boolean registrationFailedPass(){
        String message = wd.findElement(By.xpath("//*[text()='Password must contain 1 uppercase letter, 1 lowercase letter and one number ']")).getText();
        return message.contains("Password must contain 1");

    }

    public boolean registrationFailedExist(){
        new WebDriverWait(wd,5).until(ExpectedConditions.
                visibilityOf(wd.findElement(By.xpath("//*[@class='dialog-container']"))));
        String message = wd.findElement(By.xpath("//*[@class='dialog-container']")).getText();
        return message.contains("Registration error");

}

}