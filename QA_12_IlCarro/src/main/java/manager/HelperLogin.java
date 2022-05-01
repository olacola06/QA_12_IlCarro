package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperLogin extends HelperBase {

    public HelperLogin(WebDriver wd) {
        super(wd);
    }

    public void clickLogin() {
        click(By.xpath("//*[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("div input#email"), email);
        type(By.cssSelector("div input#password"), password);
    }

    public boolean loginSuccess() {
        System.out.println(wd.findElement(By.xpath("//*[@class='cdk-overlay-pane']")).getText());
        String message = wd.findElement(By.xpath("//*[@class='cdk-overlay-pane']")).getText();
        return message.contains("Logged in") & wd.findElements(By.xpath("//button[text()='Ok']")).size() > 0;

    }

    public boolean loginFail() {
        System.out.println(wd.findElement(By.xpath("//*[@class='dialog-container']")).getText());
        String message = wd.findElement(By.xpath("//*[@class='dialog-container']")).getText();
        return message.contains("Authorization error");
    }

    public void returnToMainPage() {
        click(By.cssSelector("div.header img[alt='logo']"));
    }

    public void chooseMostPopular() {

        //click(By.xpath("//span[text()='25']/parent::*"));
        //click(By.xpath("//*[text()='25']"));
        click(By.xpath("//*[contains(@class,'car-title')and contains(text(),' Audi A6 2015 ')]"));

    }

    public void chooseDates() {
        click(By.cssSelector("input#dates"));
        click(By.xpath("//*[@aria-label='Choose month and year']"));
        click(By.xpath("//*[text()=' 2022 ']"));
        click(By.xpath("//*[text()=' JUL ']"));
        click(By.cssSelector("tbody tr:nth-child(3) td:nth-child(4)"));
        click(By.cssSelector("tbody tr:nth-child(3) td:nth-child(7)"));
    }

}
